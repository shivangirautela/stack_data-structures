public class dynamicstack extends mystack{
    dynamicstack()
    {

    }
    dynamicstack(int size)
    {
        super(size);
    }

    @Override

    public void push (int data)
    {
        if(this.idx==st.length-1)
        {
            int[] temp=new int[this.st.length*2];
            for(int i=0;i<st.length;i++)
            {
                temp[i]=st[i];
            }
            this.st=temp;
        }
        super.push(data);
    }
}