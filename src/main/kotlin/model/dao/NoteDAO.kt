package org.example.model.dao

import org.example.db
import org.example.jdbc.BDD
import org.example.model.entity.Etudiant
import org.example.model.entity.Note

class NoteDAO (val bdd: BDD = db) {

    fun findAll(): MutableList<Note> {
        val result = mutableListOf<Note>()
        val sql = "SELECT * FROM note"
        val requetePreparer = bdd.connectionBDD!!.prepareStatement(sql)
        val resultatRequete = bdd.executePreparedStatement(requetePreparer)


        if (resultatRequete != null) {
            while (resultatRequete.next()) {
                val id = resultatRequete.getInt("id")
                val note = resultatRequete.getFloat("note")
                val typeEvaluation = resultatRequete.getString("typeEvaluation")
                val dateEvaluation = resultatRequete.getDate("dateEvaluation")
                result.add(Note(id, note, typeEvaluation, dateEvaluation.toLocalDate()))
            }
        }


        requetePreparer.close()
        return result
    }
}