package venki;

import java.util.Scanner;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.*;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class testMain {
    public static void main(String[] args) throws REXPMismatchException, REngineException         
{

        RConnection c = new RConnection();
        
         c.eval("data=read.csv('Training Set.csv')");
         REXP x = c.eval("mean(data$X0)");
        //REXP valueReturned = c.eval("R.version.string");
        //REXP valueReturned = c.eval("2+3");
         //System.out.println(x.asString());
         //String str = x.toString();
         System.out.println("mean: "+x.asDouble());
         
         String[] names = c.eval("names(data)").asStrings();
         int i=0;
         while(i<names.length){
        	 System.out.println(names[i]);i++; 
         }
         
         c.eval("library(EDA)");
         RList desc = c.eval("dataset_desc(mpg)").asList();
         System.out.println(desc);
         
    }
}