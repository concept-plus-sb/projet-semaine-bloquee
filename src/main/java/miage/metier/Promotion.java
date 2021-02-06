/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ismail
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Promotion implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int CodePromo;
    private String TypePromo;
}
