package br.com.fiap.EngagementPatient.data


import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

const val PACIENTE_MODEL_TABLE_NAME = "pacienteTable"
@Entity(tableName = PACIENTE_MODEL_TABLE_NAME)
@Parcelize
data class PacienteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @NonNull @ColumnInfo val nome: String,
    @NonNull @ColumnInfo val telefone: String,
    @NonNull @ColumnInfo val dataNascimento: String,
    @NonNull @ColumnInfo val doenca: String,
): Parcelable
