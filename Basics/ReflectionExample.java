package com.example.demo.basics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test{
	
	private String str; 
	  
    public Test()  {  str = "Reflection Example"; }
    
    public void method1()  { 
        System.out.println("The string is " + str); 
    } 
  
    public void method2(int n)  { 
        System.out.println("The number is " + n); 
    } 
  
    private void method3() { 
        System.out.println("Private method invoked"); 
    } 
}

public class ReflectionExample {

	public static void main(String[] args) throws Exception {

		Test obj = new Test();
		
		Class cls = obj.getClass(); 
        System.out.println("The name of class is " + cls.getName());
        
        Constructor constructor = cls.getConstructor(); 
        System.out.println("The name of constructor is " + constructor.getName());
        
        System.out.println("The public methods of class are : "); 

        Method[] methods = cls.getMethods();
		
        for (Method method:methods) 
            System.out.println(method.getName());
        
     // creates object of desired method by providing the 
        // method name and parameter class as arguments to 
        // the getDeclaredMethod 
        Method methodcall1 = cls.getDeclaredMethod("method2", 
                                                 int.class); 
  
        // invokes the method at runtime 
        methodcall1.invoke(obj, 19); 
  
        // creates object of the desired field by providing 
        // the name of field as argument to the  
        // getDeclaredField method 
        Field field = cls.getDeclaredField("s");
        
     // allows the object to access the field irrespective 
        // of the access specifier used with the field 
        field.setAccessible(true); 
  
        // takes object and the new value to be assigned 
        // to the field as arguments 
        field.set(obj, "JAVA");
        
     // Creates object of desired method by providing the 
        // method name as argument to the getDeclaredMethod 
        Method methodcall2 = cls.getDeclaredMethod("method1"); 
  
        // invokes the method at runtime 
        methodcall2.invoke(obj); 
  
        // Creates object of the desired method by providing 
        // the name of method as argument to the  
        // getDeclaredMethod method 
        Method methodcall3 = cls.getDeclaredMethod("method3"); 
  
        // allows the object to access the method irrespective  
        // of the access specifier used with the method 
        methodcall3.setAccessible(true); 
  
        // invokes the method at runtime 
        methodcall3.invoke(obj);
        
        
        
	}

}


