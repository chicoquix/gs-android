package br.com.fiap.EngagementPatient.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PacienteDAO {

    @Query("SELECT * FROM $PACIENTE_MODEL_TABLE_NAME ORDER BY id")
    fun select(): List<PacienteModel>

    @Insert
    fun insert(pacienteModel: PacienteModel)

    @Update
    fun update(pacienteModel: PacienteModel)

    @Delete
    fun delete(pacienteModel: PacienteModel)

}
