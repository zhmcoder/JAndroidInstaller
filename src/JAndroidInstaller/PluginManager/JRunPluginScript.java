/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JAndroidInstaller.PluginManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 执行插件脚本
 *
 * @author wcss
 */
public class JRunPluginScript {

    private JPluginScriptRequest requestEvent;

    /**
     * @return the requestEvent
     */
    public JPluginScriptRequest getRequestEvent() {
        return requestEvent;
    }

    /**
     * @param requestEvent the requestEvent to set
     */
    public void setRequestEvent(JPluginScriptRequest requestEvent) {
        this.requestEvent = requestEvent;
    }

    /**
     * 运行脚本
     *
     * @param workspace
     * @param scriptPath
     * @throws Exception
     */
    public void runScript(String workspace, String imageFile, String scriptPath) throws Exception {
        String destPath = JAppToolKit.JRunHelper.getCmdRunScriptBufferDir() + "/plugin_" + new Date().getTime() + ".sh";
        JRunScriptFilters.currentSelectedImageFilePath = imageFile;
        JRunScriptFilters.filterScript(scriptPath, destPath);

        ArrayList<String> startupPlugin = new ArrayList<String>();
        startupPlugin.add("#!/bin/sh");
        startupPlugin.add("cd " + workspace);
        startupPlugin.add("chmod +x " + destPath);
        startupPlugin.add(destPath);
        String runP = JAppToolKit.JRunHelper.getCmdRunScriptBufferDir() + "/run_" + new Date().getTime() + ".sh";
        JAppToolKit.JDataHelper.writeAllLines(runP, startupPlugin);
        JAppToolKit.JRunHelper.runSysCmd("chmod +x " + runP);

        Process cc = JAppToolKit.JRunHelper.runSysCmd(runP, false);
        try {
            //InputStream errorin = cc.getErrorStream();
            InputStream showin = cc.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(showin));
            String nowline = br.readLine();
            while (nowline != null) {
                if (nowline != null && nowline.startsWith("printinfo")) {
                    nowline = JRunScriptFilters.replaceStr(nowline, "printinfo", "");

                    System.out.println("需要打印 " + nowline);

                    if (this.getRequestEvent() != null) {
                        this.requestEvent.printHint(nowline);
                    }
                }
                nowline = br.readLine();
            }

            br.close();
            showin.close();
            //errorin.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    public static void main(String[] args) {
        try {
            JRunPluginScript rps = new JRunPluginScript();            
            rps.runScript("/home/wcss/","/home/wcss/image.img","/home/wcss/测试.sh");
        } catch (Exception ex) {
            Logger.getLogger(JRunScriptFilters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}