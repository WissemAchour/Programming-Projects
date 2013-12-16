/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_semes_test;

/**
 *
 * @author Wissem
 */
public class recherche_inter {
    
    public static boolean isReachableByPing(String host) {
        
    try{
            String cmd = "";
            if(System.getProperty("os.name").startsWith("Windows")) {   
                    // For Windows
                    cmd = "ping -n 1 " + host;
            } else {
                    // For Linux and OSX
                    cmd = "ping -c 1 " + host;
            }

            Process myProcess = Runtime.getRuntime().exec(cmd);
            long start=System.nanoTime();
            myProcess.waitFor();
            long elapsedTime = System.nanoTime() - start;
            if(myProcess.exitValue() == 0&&elapsedTime<1000000000) {

                    return true;
            } else {

                    return false;
            }

    } catch( Exception e ) {

            e.printStackTrace();
            return false;
    }
}
    

    
}
