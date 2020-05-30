import java.util.*;
public  class stack{
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
    public static int infix_eval(String s)
    {
        Stack<Integer> nst=new Stack<>();
        Stack<Character> cst=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
         if(ch>='0' && ch<='9')
         {
         nst.push(ch-'0');
         }
         else if(ch=='(')
         {
             cst.push(ch);
         }
         else if(isoperator(ch))
         {
                 while(cst.size()!=0 && priority(cst.peek()) > priority(ch) && cst.peek() != '(')
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
            while(cst.peek()!='(')
            {
                int val1=nst.pop();
                int val2=nst.pop();
                char c=cst.pop();

                int ans=performoperation(val1,val2,c);
                nst.push(ans);  
            }
            nst.pop();
        }
    }
        while(cst.size()!=0)
                 {
                   int val1=nst.pop();
                   int val2=nst.pop();
                   char c=cst.pop();

                   int ans=performoperation(val1,val2,c);
                   nst.push(ans);
                 } 
        
    
   return nst.pop();
    }
    public static String performoperation2(int val1,int val2,char c)
    {
        if(c=='+')
        return to_string(val2+val1+"+");
        else if(c=='-')
        return to_string(val2+val1+"-");
        else if(c=='*')
        return to_string(val2+val1+"*");
        else if(c=='/')
        return to_string(val2+val1+"/");
        else 
        return to_string(val2+val1+"^");
    }
    public static String infix_to_postfix(String s)
    {
     Stack<Character> nst=new Stack<>();
        Stack<Character> cst=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
         if(ch>='0' && ch<='9')
         {
         nst.push(ch);
         }
         else if(ch=='(')
         {
             cst.push(ch);
         }
         else if(isoperator(ch))
         {
                 while(cst.size()!=0 && priority(cst.peek()) > priority(ch) && cst.peek() != '(')
                 {
                   int val1=nst.pop();
                   int val2=nst.pop();
                   char c=cst.pop();

                   String ans=performoperation(val1,val2,c);
                   nst.push(ans);
                 }
        }
        
        else
        {
            while(cst.peek()!='(')
            {
                int val1=nst.pop();
                int val2=nst.pop();
                char c=cst.pop();

                int ans=performoperation(val1,val2,c);
                nst.push(ans);  
            }
            nst.pop();
        }
    }
        while(cst.size()!=0)
                 {
                   int val1=nst.pop();
                   int val2=nst.pop();
                   char c=cst.pop();

                   int ans=performoperation(val1,val2,c);
                   nst.push(ans);
                 } 
        return nst.pop();
        }
     /*
    public static String reverse_string(String str)
    {
        int i=0;
        int j=str.length()-1;
        while(i<=j)
        {
            str[i]=str[j];
            i++;
            j--;
        }
        return str;
    }
    public static String reverse_brackets(String str)
    {
       for(int i=0;i<str.length();i++)
        {
            if(str[i]=='(')
            str[i]=')';
            else if(str[i]==')')
            str[i]='(';
        } 
        return str;
    }
        */
        public static void next_greater_left(int[] a)
        {
            Stack<Integer> st=new Stack<>();
            for(int i=0;i<a.length;i++)
            {
                while(st.size()!=0 && st.peek()<=a[i])
                {
                    st.pop();
                }
                if(st.size()==0)
                System.out.println(a[i]+"=>"+"-1");
                else
                System.out.println(a[i]+"=>"+st.peek());

                st.push(a[i]);
            }
        }
        public static int largest_histogram_area(int[] height)
        {
           Stack<Integer> st=new Stack<>();
           st.push(-1);   //imp
           int i=0;
           int maxarea=0;
           while(i<height.length)
           {
              while(st.peek()!=-1 && height[st.peek()]>=height[i]) //imp
              {
                  int ht=height[st.pop()];
                  int area=ht * (i- st.peek()-1);
                  maxarea=Math.max(maxarea,area);
              }
              st.push(i);
              i++;
            }
              while(st.peek()!=-1)
              {
                  int ht=height[st.pop()];
                  int area=ht * (i- st.peek()-1);
                  maxarea=Math.max(maxarea,area);
              }
           
           return maxarea;
        }
    public static int max_area_in_matrix(char[][] arr)
    {
        int max_=0;
        if(arr.length==0)
        return 0;
        int[] ar=new int[arr[0].length];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                ar[j]=(arr[i][j]=='0')? 0 : ar[j]+1;
            }
            max_=Math.max(max_,largest_histogram_area(ar));
        }
        return max_;
    }
    public static class basic{
        Stack<Integer> st = new Stack<>();
        int minsf=0;
        public void push()
        {

        }
        public int pop()
        {
            if(st.size()==0)
            return -1;

            if(st.peek()< minsf){
                int actualvalue=minsf;
                int recoveredminsf= 2* minsf -st.pop();

                minsf=recoveredminsf;
                return actualvalue;
            }
            else
            return st.pop();
        }
    }
    public static 
    public static void main(String[] args)
    {
       //String str="8+4*3-9/3^(2-1)";
       //System.out.print(infix_eval(str));
       //System.out.print(infix_to_postfix(str));
       //next_greater_left(arr);
       //System.out.println("");
       //char[][] a={{'1','0','0','1'},
       //             {'1','1','1','1'},
       //             {'1','1','1','1'},
       //             {'1','0','0','1'}};
       //System.out.println(max_area_in_matrix(a));
       //System.out.print(largest_histogram_area(arr));
    }

} 