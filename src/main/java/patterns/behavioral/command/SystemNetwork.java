package patterns.behavioral.command;

import java.security.SecureRandom;

//receiver
public interface SystemNetwork {
    boolean openConnection();

    boolean closeConnection();

    Object fetchStream();
}

class WindowsSystemNetwork implements SystemNetwork {
    private boolean isConnected;

    @Override
    public boolean openConnection() {
        if (isConnected = new SecureRandom().nextBoolean()) {
            System.out.println("Connected Successfully in Microsoft Windows");
            return true;
        }
        System.out.println("Connection failed in Microsoft Windows");
        return false;
    }

    @Override
    public boolean closeConnection() {
        if (!isConnected) {
            System.out.println("Can not close the connection in Microsoft Windows");
            return false;
        }
        System.out.println("Connection closed in Microsoft Windows");
        return true;
    }

    @Override
    public Object fetchStream() {
        Object o = isConnected ? "Microsoft Windows" + new SecureRandom().nextInt(100 << 10) : null;
        System.out.println(o);
        return o;
    }
}


class UnixSystemNetwork implements SystemNetwork {
    boolean isConnected;

    @Override
    public boolean openConnection() {
        if (isConnected = new SecureRandom().nextBoolean()) {
            System.out.println("Connected Successfully in Unix");
            return true;
        }
        System.out.println("Connection failed in Unix");
        return false;
    }

    @Override
    public boolean closeConnection() {
        if (!isConnected) {
            System.out.println("Can not close the connection in Unix");
            return false;
        }
        System.out.println("Connection closed in Unix");
        return true;
    }

    @Override
    public Object fetchStream() {
        Object o = isConnected ? "Unix" + new SecureRandom().nextInt(100 << 10) : null;
        System.out.println(o);
        return o;

    }
}

//command
abstract class NetworkOpsCommand {
    private final SystemNetwork systemNetwork;

    public NetworkOpsCommand(SystemNetwork systemNetwork) {
        this.systemNetwork = systemNetwork;
    }

    abstract void execute();

    public SystemNetwork getSystemNetwork() {
        return systemNetwork;
    }
}

class OpenConnectionCommand extends NetworkOpsCommand {

    public OpenConnectionCommand(SystemNetwork systemNetwork) {
        super(systemNetwork);
    }

    @Override
    void execute() {
        getSystemNetwork().openConnection();
    }
}

class CloseConnectionCommand extends NetworkOpsCommand {

    public CloseConnectionCommand(SystemNetwork systemNetwork) {
        super(systemNetwork);
    }

    @Override
    void execute() {
        getSystemNetwork().closeConnection();
    }
}


class FetchStreamCommand extends NetworkOpsCommand {

    public FetchStreamCommand(SystemNetwork systemNetwork) {
        super(systemNetwork);
    }

    @Override
    void execute() {
        getSystemNetwork().fetchStream();
    }
}

//invoker
class SystemNetworkInvoker{
    private NetworkOpsCommand networkOpsCommand;

    public void setNetworkOpsCommand(NetworkOpsCommand networkOpsCommand) {
        this.networkOpsCommand = networkOpsCommand;
    }

    public void execute(){
        networkOpsCommand.execute();
    }
}

//factory method
class SystemNetworkUtil {
    public static SystemNetwork getSystemNetwork() throws Exception {
        String os = System.getProperty("os.name");
        if (os.equals("Windows 10"))
            return new WindowsSystemNetwork();
        else if (os.equals("Unix"))
            return new UnixSystemNetwork();
        throw new Exception("unsupported os");
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        SystemNetwork systemNetwork = SystemNetworkUtil.getSystemNetwork();
        SystemNetworkInvoker invoker=new SystemNetworkInvoker();

        invoker.setNetworkOpsCommand(new OpenConnectionCommand(systemNetwork));
        invoker.execute();

        invoker.setNetworkOpsCommand(new FetchStreamCommand(systemNetwork));
        invoker.execute();

        invoker.setNetworkOpsCommand(new CloseConnectionCommand(systemNetwork));
        invoker.execute();

    }
}

