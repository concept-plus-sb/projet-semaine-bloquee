/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.util.ArrayList;
import java.util.Set;
import miage.metier.Client;
import miage.metier.Commande;
import miage.metier.EnumEtatCom;

/**
 *
 * @author Afaf
 */
public class AfficherCommande {
    
    public static ArrayList<Commande> mesCommandes(Client cli){
        
        Set <Commande> commandes= cli.getCommandes();
        ArrayList<Commande> commandeEncours = new ArrayList<>();
        
        for(Commande c: commandes){
            if(c.getEtatCom()== EnumEtatCom.encours)
            {
                commandeEncours.add(c);
            }
        }
    return commandeEncours;
    }
    
    
}
