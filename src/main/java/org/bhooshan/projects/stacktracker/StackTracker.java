package org.bhooshan.projects.stacktracker;

import javassist.*;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

/**
 * Created with IntelliJ IDEA.
 * User: bhooshan
 * Date: 10/8/13
 * Time: 7:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class StackTracker {

    private ClassPool classPool = null;

    public StackTracker() {
        this(null);
    }

    public StackTracker(ClassPath classPath) {
        initialize(classPath);
    }

    private void initialize(ClassPath classPath) {
        classPool = ClassPool.getDefault();
        if (classPath != null) {
            classPool.appendClassPath(classPath);
        }
    }

    public void go(String className, String methodName) throws NotFoundException, CannotCompileException {
        CtClass ctClass = classPool.getCtClass(className);
        CtMethod ctMethod = ctClass.getDeclaredMethod(methodName);
        ctMethod.instrument(
                new ExprEditor() {
                    public void edit(MethodCall mc) {
                        try {
                            System.out.println(mc.getClassName() + "." + mc.getMethod() + " " + mc.getSignature() + " " + mc.getLineNumber());
                        } catch (NotFoundException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    }
                }
        );
    }

    public static void main(String [] args) throws NotFoundException, CannotCompileException {
        /*if(args.length < 3) {
            usage();
        }
        String classpath = args[0];
        String classz = args[1];
        String method = args[2];*/
        StackTracker stackTracker = new StackTracker();
        stackTracker.go("java.lang.Object", "toString");
    }

    private static void usage() {
        System.out.println("Stack Tracker!");
        System.out.println("Usage:");
        System.out.println("java org.bhooshan.projects.stacktracker.StackTracker <classpath> <classname> <methodname>");
        System.exit(1);
    }
}
