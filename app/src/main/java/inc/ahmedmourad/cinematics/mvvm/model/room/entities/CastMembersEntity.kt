package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = CastMembersEntity.TABLE_NAME,
        foreignKeys = [
            ForeignKey(
                    entity = MoviesEntity::class,
                    parentColumns = [MoviesEntity.COLUMN_ID],
                    childColumns = [CastMembersEntity.COLUMN_MOVIE_ID],
                    onDelete = ForeignKey.NO_ACTION),
            ForeignKey(
                    entity = PersonsEntity::class,
                    parentColumns = [PersonsEntity.COLUMN_PERSON_ID],
                    childColumns = [CastMembersEntity.COLUMN_PERSON_ID],
                    onDelete = ForeignKey.NO_ACTION)],
        indices = [
            Index(value = [CastMembersEntity.COLUMN_MOVIE_ID], unique = false),
            Index(value = [CastMembersEntity.COLUMN_PERSON_ID], unique = false)])
data class CastMembersEntity(
        @SerializedName(value = "credit_id") @PrimaryKey @ColumnInfo(name = COLUMN_CREDIT_ID) var credit_id: String,
        @Transient @ColumnInfo(name = COLUMN_MOVIE_ID) var movie_id: Long,
        @SerializedName(value = "id") @ColumnInfo(name = COLUMN_PERSON_ID) var person_id: Long,
        @SerializedName(value = "name") @ColumnInfo(name = COLUMN_NAME) var name: String?,
        @SerializedName(value = "character") @ColumnInfo(name = COLUMN_CHARACTER) var character: String,
        @SerializedName(value = "original_title") @ColumnInfo(name = COLUMN_ORIGINAL_TITLE) var original_title: String?,
        @SerializedName(value = "profile_path", alternate = ["poster_path"]) @ColumnInfo(name = COLUMN_IMAGE_PATH) var image_path: String?,
        @Transient @ColumnInfo(name = COLUMN_SOURCE) var source: Int) {

    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "cast_members"

        @Transient
        @Ignore
        const val COLUMN_CREDIT_ID = "credit_id"

        @Transient
        @Ignore
        const val COLUMN_MOVIE_ID = "movie_id"

        @Transient
        @Ignore
        const val COLUMN_PERSON_ID = "person_id"

        @Transient
        @Ignore
        const val COLUMN_NAME = "name"

        @Transient
        @Ignore
        const val COLUMN_CHARACTER = "character"

        @Transient
        @Ignore
        const val COLUMN_ORIGINAL_TITLE = "original_title"

        @Transient
        @Ignore
        const val COLUMN_IMAGE_PATH = "image_path"

        @Transient
        @Ignore
        const val COLUMN_SOURCE = "source"

        @Transient
        @Ignore
        const val SOURCE_MOVIE = 0

        @Transient
        @Ignore
        const val SOURCE_PERSON = 1
    }
}
