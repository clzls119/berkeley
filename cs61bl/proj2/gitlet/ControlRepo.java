package gitlet;

import java.io.File;

/**
 * Created by baovydang on 7/19/17.
 */
public class ControlRepo {

    public static void runCommand(String[] args) throws Exception {
        String firstArg = "", secondArg = "", thirdArg = "", fourthArg = "";
        File pwd = new File(System.getProperty("user.dir"));  //   pwd = adam/group238
        if (args == null) {
            throw new IllegalArgumentException("Please enter a command.");
        } else if (args != null && args.length == 1) {
            firstArg = args[0];
        } else {
            firstArg = args[0]; secondArg = args[1];
        }
        if (firstArg.equals("init")) {
            Init.doIt();
        } else {
            if (Utils.join(pwd.toString(), "REPO").exists()) {
                System.out.println("Not in an initialized gitlet directory.");
            } else {
                Gitlet deRepo = RepoUtils.getRepo();
                switch (firstArg) {
                    case "add":
                        Add add = new Add();
                        add.doIt(deRepo, secondArg);
                        break;
                    case "commit":
                        if (secondArg.equals("")) {
                            System.out.println("Please enter a commit message.");
                            break;
                        } else {
                            Commit commit = new Commit();
                            commit.doIt(deRepo, secondArg);
                            break;
                        }
                    case "rm":
                        Rm remove = new Rm();
                        remove.doIt(deRepo, secondArg);
                        break;
                    case "checkout":
                        Checkout checkout = new Checkout();
                        checkout.doIt(deRepo, args);
                        break;
                    case "branch":
                        Branch branch = new Branch();
                        branch.doIt(deRepo, secondArg);
                        break;
                    case "rm-branch":
                        RemoveBranch rmBranch = new RemoveBranch();
                        rmBranch.doIt(deRepo, secondArg);
                        break;
                    case "reset":
                        Reset reset = new Reset();
                        reset.doIt(deRepo, secondArg);
                        break;
                    case "status":
                        Status status = new Status();
                        status.doIt(deRepo, secondArg);
                        break;
                    case "log":
                    case "global-log":
                    case "find":
                        Log log = new Log();
                        log.doIt(firstArg, secondArg);
                        break;
                    case "merge":
                        Merge m = new Merge();
                        m.doIt(deRepo, secondArg);
                        break;
                    default:
                        System.out.println("No command with that name exists.");
                }
            }
        }
    }
}