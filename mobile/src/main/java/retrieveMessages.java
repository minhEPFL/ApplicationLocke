import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class retrieveMessages {

    private static final Uri SMS_URI_INBOX = Uri.parse("content://sms/inbox");

    private void retrieveMessages(ContentResolver contentResolver)
    {
        final Cursor cursor = contentResolver.query(SMS_URI_INBOX, null, null, null, null);

        if (cursor == null)
        {
            Log.e("retrieveMessages", "Cannot retrieve the messages");
            return;
        }
        if (cursor.moveToFirst() == true)
        {

            //Toast.makeText(context, cursor.getString(cursor.getColumnIndexOrThrow("body")), Toast.LENGTH_LONG).show();
            do
            {
                String a = cursor.getString(cursor.getColumnIndexOrThrow("body"));

                String b = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                final String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                final String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                Log.d("retrieveContacts", "The message with from + '" + address + "' with the body '" + body + "' has been retrieved");

            }
            while (cursor.moveToNext() == true);
        }
        if (cursor.isClosed() == false)
        {
            cursor.close();
        }
    }
}
