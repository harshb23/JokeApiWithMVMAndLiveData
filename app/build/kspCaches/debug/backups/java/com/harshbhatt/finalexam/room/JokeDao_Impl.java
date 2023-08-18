package com.harshbhatt.finalexam.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class JokeDao_Impl implements JokeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<JokeEntity> __insertionAdapterOfJokeEntity;

  public JokeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfJokeEntity = new EntityInsertionAdapter<JokeEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `jokes` (`id`,`joke`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, JokeEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getJoke() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getJoke());
        }
      }
    };
  }

  @Override
  public Object insertJoke(final JokeEntity joke, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfJokeEntity.insert(joke);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getRandomJoke(final Continuation<? super JokeEntity> continuation) {
    final String _sql = "SELECT * FROM jokes ORDER BY RANDOM() LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<JokeEntity>() {
      @Override
      public JokeEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfJoke = CursorUtil.getColumnIndexOrThrow(_cursor, "joke");
          final JokeEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpJoke;
            if (_cursor.isNull(_cursorIndexOfJoke)) {
              _tmpJoke = null;
            } else {
              _tmpJoke = _cursor.getString(_cursorIndexOfJoke);
            }
            _result = new JokeEntity(_tmpId,_tmpJoke);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
