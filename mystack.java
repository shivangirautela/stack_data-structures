import com.oracle.webservices.internal.api.EnvelopeStyle;

public class mystack{
    public static void main(String[] args)
    {
      // mystack s =new mystack();
     //  for(int i=0;i<10;i++)
     //  {
     //      s.push(i+10);
     //  }
     //  String str="8+4*3-9/3^(2-1)";
       System.out.print(infix_eval(str));
    }
    protected int[] st;
    protected int idx=-1;

    mystack()
    {
        this.st=new int[10];
    }

    mystack(int size)
    {
        this.st=new int[size];
    }

    public void print()
    {
        System.out.print("[");
        for(int i=idx;i>0;i--)
        {
            System.out.print(st[i] + ",");
        }
        System.out.println(st[0]+"]");
    }
    public int size()
    {
        return idx+1;
    }
    public boolean isEmpty()
    {
        return idx==-1;
    }
    public int top() {
        if (idx == -1) {
            System.err.println("StackIsEmpty");
            return -1;
        }
        return st[idx];
    }
    public void push(int data)
    {
     if(idx==st.length)
     {
      System.out.println("stackoverflow");
      return ;
     }
     idx++;
     this.st[idx]=data;
    }
    public  int pop()
    {
        if(idx==-1)
        {
            System.out.print("stackisempty");
        }
        int rv=this.st[idx];
        this.st[idx]=0;
        idx--;
        return rv;
    }
    public static boolean isoperator(char ch)
    {
        if(ch=='+'||ch=='-'|| ch=='/'||ch=='*'||ch=='^')
        return true;

        return false;
    }
    public static int  priority (char ch)
    {
        if(ch=='+' || ch=='-')
        return 1;
        else if(ch=='*'|| ch=='/'|| ch=='%' )
        return 2;
        else if(ch=='^')
        return 3;
    
        return -1;
    }
    public static int performoperation(int val1,int val2,char c)
    {
        if(c=='+')
        return val2+val1;
        else if(c=='-')
        return val2-val1;
        else if(c=='*')
        return val2*val1;
        else if(c=='/')
        return val2/val1;
        else 
        return (int)Math.pow(val2,val1);
    }
    public static String infix_eval(String s)
    {
        Stack<integer> nst=new Stack<>();
        Stack<integer> cst=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
         if(ch>='0' && ch<='9')
         {
         nst.push(ch);
         }
         else if(cst.size()!=0 || priority(cst.top())<priority(ch))
         {
             cst.push(ch);
         }
         else if(ch=='(')
         {
             cst.push(ch);
         }
         else if(cst.size()!=0)
         {
            if(isoperator(ch))
            {
                 while(cst.size()!=0 && priority(cst.top()) > priority(ch) && cst.top() != '(')
                 {
                   int val1=nst.pop();
                   int val2=nst.pop();
                   char c=cst.pop();

                   int ans=performoperation(val1,val2,c);
                   nst.push(ans);
                 }
            }
        }
        else if(ch==')')
        {
            while(cst.top()!='(')
            {
                int val1=nst.pop();
                int val2=nst.pop();
                char c=cst.pop();

                int ans=performoperation(val1,val2,c);
                nst.push(ans);  
            }
        }
        else 
        {
                 while(cst.size()!=0)
                 {
                   int val1=nst.pop();
                   int val2=nst.pop();
                   char c=cst.pop();

                   int ans=performoperation(val1,val2,c);
                   nst.push(ans);
                 } 
        }
    }
   return nst.pop();
    }
}