import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.CLexer;
import com.CParser;

public class App {
	public static void main( String[] args )
    {
        ANTLRInputStream inputStream = new ANTLRInputStream(
        		" float f(float x){     return(1/(1+pow(x,2))); } void main() {     int i,n;     float x0,xn,h,y[20],so,se,ans,x[20];     printf(\"\n Enter values of x0,xn,h:\n\");     scanf(\"%f%f%f\",&x0,&xn,&h);     n=(xn-x0)/h;     if(n%2==1)     {         n=n+1;     }     h=(xn-x0)/n;     printf(\"\nrefined value of n and h are:%d  %f\n\",n,h);     printf(\"\n Y values \n\");     for(i=0; i<=n; i++)     {         x[i]=x0+i*h;         y[i]=f(x[i]);         printf(\"\n%f\n\",y[i]);     }     so=0;     se=0;     for(i=1; i<n; i++)     {         if(i%2==1)         {             so=so+y[i];         }         else         {             se=se+y[i];         }     }     ans=h/3*(y[0]+y[n]+4*so+2*se);     printf(\"\nfinal integration is %f\",ans);     getch(); }  ");
        CLexer markupLexer = new CLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(markupLexer);
        CParser markupParser = new CParser(commonTokenStream);
        markupParser.setBuildParseTree(true);
        ParseTreeWalker walker = new ParseTreeWalker();
        CReader reader = new CReader();
        walker.walk(reader, markupParser.functionDefinition());
        System.out.println(reader.getFunctionName().size());
        for(String re : reader.getFunctionName())
        	System.out.println(re);
    }
}