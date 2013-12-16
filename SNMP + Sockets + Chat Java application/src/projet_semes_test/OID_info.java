/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_semes_test;

import javax.swing.JTextField;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/**
 *
 * @author Wissem
 */
public class OID_info {

    /**
     * @param args the command line arguments
     */
    public String recherche(String adresse,String oid){

        String str="";
        try {
            String strAddress = adresse+"/161";
            Address targetAddress = new UdpAddress(strAddress);

            TransportMapping transport = new DefaultUdpTransportMapping();
            transport.listen();
            Snmp snmp = new Snmp(transport);

            CommunityTarget target = new CommunityTarget();
            target.setCommunity(new OctetString("public"));
            target.setAddress(targetAddress);
            target.setVersion(SnmpConstants.version1);
            target.setRetries(2);
            target.setTimeout(5000);

            PDU pdu = new PDU();

            pdu.add(new VariableBinding(new OID(oid)));
 
            pdu.setType(PDU.GETNEXT);

            ResponseEvent response = snmp.get(pdu, target);
            if (response != null) {
                PDU pduresponse = response.getResponse();
                str = pduresponse.getVariableBindings().firstElement().getVariable().toString();
            } else {
                System.out.println("Le temps a été écoulé");
            }
            snmp.close();
        } catch (Exception e) {
            System.out.print("Une erreur a été rencontrée: vérifier votre adresse IP ou votre OID " + e);
        }
        return str;
    }
    /*public static void main(String[] args) {
        int i=1;
        // TODO code application logic here
                //System.out.println(new Projet_semes_test().recherche("192.168.0.5", "1.3.6.1.2.1.1.6.0"));
        // System.out.println(new Projet_semes_test().recherche("127.0.0.1","1.3.6.1.2.1.25.6.3.1.2.1")); les logiciels
        //System.out.println(new Projet_semes_test().recherche("127.0.0.1",".1.3.6.1.2.1.25.2.2.0"));// RAM size
       // System.out.println(new Projet_semes_test().recherche("127.0.0.1","1.3.6.1.2.1.25.3.2.1.2.2"));
        
        //1.3.6.1.2.1.25.2.3.1.j.i stockage
        //1.3.6.1.2.1.25.3.2.1."+i+"."+j equipements
        
        //System.out.println(new Projet_semes_test().recherche("127.0.0.1","1.3.6.1.2.1.25.2.3.1.5.1"));
         //System.out.println(new Projet_semes_test().recherche("127.0.0.1","1.3.6.1.2.1.25.3.2.1.5."+i)); actif ou non
        while(!new OID_info().recherche("127.0.0.1","1.3.6.1.2.1.25.3.2.1.3."+i).equals("Null"))
        {
            System.out.print(new OID_info().recherche("127.0.0.1","1.3.6.1.2.1.25.3.2.1.3."+i));
            System.out.print(new OID_info().recherche("127.0.0.1","1.3.6.1.2.1.25.3.2.1.5."+i));
            System.out.print(new OID_info().recherche("127.0.0.1","1.3.6.1.2.1.25.3.2.1.6."+i));
            
            System.out.println();
            i++;
        }
       
    }*/

   
}
