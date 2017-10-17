/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendabuildergui;

/**
 *
 * @author Sun
 */
public class Members {
    private String [] names;
    
    public Members ()
    {
        names = new String [] {"John","Jane","Henry","Mary","Steve","Tom","Hilary","Jennifer","Mandi","Chris","Kristin","Dave","David","JP","Mandi","TBD"};
    }
    
    public String [] getMemberList()
    {
        return names;
    }
}
