public class Record
{
    public String last;
    public String first;
    public int age;
    
    //toString Method
    public String toString()
    {
        String rec = "";
        rec = rec+last+first+age;
        return rec;
    }

}