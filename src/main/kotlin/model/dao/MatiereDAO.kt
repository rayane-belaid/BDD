package org.example.model.dao

import org.example.db
import org.example.jdbc.BDD
import org.example.model.entity.Matiere

class MatiereDAO (val bdd: BDD = db) {

    fun findAll(): MutableList<Matiere> {
        val result = mutableListOf<Matiere>()
        val sql = "SELECT * FROM matiere"
        val requetePreparer = bdd.connectionBDD!!.prepareStatement(sql)
        val resultatRequete = bdd.executePreparedStatement(requetePreparer)


        if (resultatRequete != null) {
            while (resultatRequete.next()) {
                val id = resultatRequete.getInt("id")
                val nom = resultatRequete.getString("nom")
                val coefficient = resultatRequete.getFloat("coefficient")
                result.add(Matiere(id, nom, coefficient)
            }
        }
    }
}