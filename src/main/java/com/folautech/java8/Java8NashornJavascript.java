package com.folautech.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.github.javafaker.Faker;

/**
 * 
 * Nashorn is a JavaScript engine developed by Oracle that was introduced with Java 8. It replaces the previous
 * JavaScript engine, Rhino, which was bundled with Java 6 and 7. Nashorn is fully based on the ECMAScript-262 5.1
 * standard, with some additional features. It was created to offer significantly improved performance and is
 * implemented through the Java-based javax.script API.
 * 
 * 
 * 
 */
public class Java8NashornJavascript {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("Java8NashornJavascript");

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        try {
            engine.eval("print('Hello from Nashorn!');");
        } catch (ScriptException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String script = "var Runnable = Java.type('java.lang.Runnable');" + "var r = new Runnable() { run: function() { print('Running in a thread!'); } };"
                + "var Thread = Java.type('java.lang.Thread');" + "var th = new Thread(r);" + "th.start();" + "th.join();";

        try {
            engine.eval(script);
        } catch (ScriptException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
