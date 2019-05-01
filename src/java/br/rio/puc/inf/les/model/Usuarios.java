/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rio.puc.inf.les.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisg
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByCodUsuario", query = "SELECT u FROM Usuarios u WHERE u.codUsuario = :codUsuario")
    , @NamedQuery(name = "Usuarios.findByContatoUsuario", query = "SELECT u FROM Usuarios u WHERE u.contatoUsuario = :contatoUsuario")
    , @NamedQuery(name = "Usuarios.findByNomeUsuario", query = "SELECT u FROM Usuarios u WHERE u.nomeUsuario = :nomeUsuario")
    , @NamedQuery(name = "Usuarios.findByTipoUsuariol", query = "SELECT u FROM Usuarios u WHERE u.tipoUsuariol = :tipoUsuariol")
    , @NamedQuery(name = "Usuarios.findByEmailUsuario", query = "SELECT u FROM Usuarios u WHERE u.emailUsuario = :emailUsuario")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "codUsuario")
    private Integer codUsuario;
    @Column(name = "contatoUsuario")
    private String contatoUsuario;
    @Column(name = "nomeUsuario")
    private String nomeUsuario;
    @Column(name = "tipoUsuariol")
    private String tipoUsuariol;
    @Basic(optional = false)
    @Column(name = "emailUsuario")
    private String emailUsuario;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String emailUsuario) {
        this.idUsuario = idUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getContatoUsuario() {
        return contatoUsuario;
    }

    public void setContatoUsuario(String contatoUsuario) {
        this.contatoUsuario = contatoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTipoUsuariol() {
        return tipoUsuariol;
    }

    public void setTipoUsuariol(String tipoUsuariol) {
        this.tipoUsuariol = tipoUsuariol;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rio.puc.inf.les.model.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
