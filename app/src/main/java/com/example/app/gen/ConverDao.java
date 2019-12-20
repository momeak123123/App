package com.example.app.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.app.Sqlentity.Conver;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONVER".
*/
public class ConverDao extends AbstractDao<Conver, Long> {

    public static final String TABLENAME = "CONVER";

    /**
     * Properties of entity Conver.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Conversations = new Property(1, Long.class, "conversations", false, "CONVERSATIONS");
        public final static Property SendId = new Property(2, Long.class, "sendId", false, "SEND_ID");
        public final static Property Sendname = new Property(3, String.class, "sendname", false, "SENDNAME");
        public final static Property Sendsrc = new Property(4, String.class, "sendsrc", false, "SENDSRC");
        public final static Property Type = new Property(5, int.class, "type", false, "TYPE");
    }


    public ConverDao(DaoConfig config) {
        super(config);
    }
    
    public ConverDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONVER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CONVERSATIONS\" INTEGER," + // 1: conversations
                "\"SEND_ID\" INTEGER," + // 2: sendId
                "\"SENDNAME\" TEXT," + // 3: sendname
                "\"SENDSRC\" TEXT," + // 4: sendsrc
                "\"TYPE\" INTEGER NOT NULL );"); // 5: type
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_CONVER_CONVERSATIONS ON \"CONVER\"" +
                " (\"CONVERSATIONS\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONVER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Conver entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long conversations = entity.getConversations();
        if (conversations != null) {
            stmt.bindLong(2, conversations);
        }
 
        Long sendId = entity.getSendId();
        if (sendId != null) {
            stmt.bindLong(3, sendId);
        }
 
        String sendname = entity.getSendname();
        if (sendname != null) {
            stmt.bindString(4, sendname);
        }
 
        String sendsrc = entity.getSendsrc();
        if (sendsrc != null) {
            stmt.bindString(5, sendsrc);
        }
        stmt.bindLong(6, entity.getType());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Conver entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long conversations = entity.getConversations();
        if (conversations != null) {
            stmt.bindLong(2, conversations);
        }
 
        Long sendId = entity.getSendId();
        if (sendId != null) {
            stmt.bindLong(3, sendId);
        }
 
        String sendname = entity.getSendname();
        if (sendname != null) {
            stmt.bindString(4, sendname);
        }
 
        String sendsrc = entity.getSendsrc();
        if (sendsrc != null) {
            stmt.bindString(5, sendsrc);
        }
        stmt.bindLong(6, entity.getType());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Conver readEntity(Cursor cursor, int offset) {
        Conver entity = new Conver( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // conversations
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // sendId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sendname
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // sendsrc
            cursor.getInt(offset + 5) // type
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Conver entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setConversations(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setSendId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setSendname(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSendsrc(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setType(cursor.getInt(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Conver entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Conver entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Conver entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}