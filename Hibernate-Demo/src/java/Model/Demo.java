/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HK
 */
@Entity
@Table(name = "DEMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demo.findAll", query = "SELECT d FROM Demo d")
    , @NamedQuery(name = "Demo.findByUsername", query = "SELECT d FROM Demo d WHERE d.username = :username")
    , @NamedQuery(name = "Demo.findByPassword", query = "SELECT d FROM Demo d WHERE d.password = :password")
    , @NamedQuery(name = "Demo.findByEmail", query = "SELECT d FROM Demo d WHERE d.email = :email")})
public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private Integer password;
    @Column(name = "EMAIL")
    private String email;

    public Demo() {
    }

    public Demo(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demo)) {
            return false;
        }
        Demo other = (Demo) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Demo[ username=" + username + " ]";
    }
    
}
