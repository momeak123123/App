package com.example.myapplication.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.myapplication.Model.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MemberId = new Property(1, Long.class, "memberId", false, "MEMBER_ID");
        public final static Property MemberSex = new Property(2, int.class, "memberSex", false, "MEMBER_SEX");
        public final static Property MemberNickname = new Property(3, String.class, "memberNickname", false, "MEMBER_NICKNAME");
        public final static Property MemberIcon = new Property(4, String.class, "memberIcon", false, "MEMBER_ICON");
        public final static Property State = new Property(5, Boolean.class, "state", false, "STATE");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"MEMBER_ID\" INTEGER," + // 1: memberId
                "\"MEMBER_SEX\" INTEGER NOT NULL ," + // 2: memberSex
                "\"MEMBER_NICKNAME\" TEXT," + // 3: memberNickname
                "\"MEMBER_ICON\" TEXT," + // 4: memberIcon
                "\"STATE\" INTEGER);"); // 5: state
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long memberId = entity.getMemberId();
        if (memberId != null) {
            stmt.bindLong(2, memberId);
        }
        stmt.bindLong(3, entity.getMemberSex());
 
        String memberNickname = entity.getMemberNickname();
        if (memberNickname != null) {
            stmt.bindString(4, memberNickname);
        }
 
        String memberIcon = entity.getMemberIcon();
        if (memberIcon != null) {
            stmt.bindString(5, memberIcon);
        }
 
        Boolean state = entity.getState();
        if (state != null) {
            stmt.bindLong(6, state ? 1L: 0L);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long memberId = entity.getMemberId();
        if (memberId != null) {
            stmt.bindLong(2, memberId);
        }
        stmt.bindLong(3, entity.getMemberSex());
 
        String memberNickname = entity.getMemberNickname();
        if (memberNickname != null) {
            stmt.bindString(4, memberNickname);
        }
 
        String memberIcon = entity.getMemberIcon();
        if (memberIcon != null) {
            stmt.bindString(5, memberIcon);
        }
 
        Boolean state = entity.getState();
        if (state != null) {
            stmt.bindLong(6, state ? 1L: 0L);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // memberId
            cursor.getInt(offset + 2), // memberSex
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // memberNickname
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // memberIcon
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0 // state
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMemberId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setMemberSex(cursor.getInt(offset + 2));
        entity.setMemberNickname(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMemberIcon(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setState(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
