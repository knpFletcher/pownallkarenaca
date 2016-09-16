package com.karenpownall.android.aca.notetoself;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoteAdapter = new NoteAdapter();
        ListView listNote = (ListView) findViewById(R.id.listView);
        listNote.setAdapter(mNoteAdapter);

        //Handle clicks on the ListView
        listNote.setOnItemClickListener(new AdapterView.OnItemClickListener(){ //inner annonymous class
            @Override
            public void onItemClick(AdapterView<?>adapter, View view, int whichItem, long id){
                /*
                Create a temporary Note
                which is a reference to the Note
                that has been clicked
                 */
                Note tempNote = mNoteAdapter.getItem(whichItem);

                //Create a new dialog window
                DialogShowNote dialog = new DialogShowNote();
                //Send in a reference to teh note to be shown
                dialog.sendNoteSelected(tempNote);

                //show the dialog window with the note in it
                dialog.show(getFragmentManager(), "");
            }
        });
    }

    public void createNewNote(Note n) {
        mNoteAdapter.addNote(n);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_add) {
            DialogNewNote dialog = new DialogNewNote();
            dialog.show(getFragmentManager(), "456");
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    //inner class
    public class NoteAdapter extends BaseAdapter{
        List<Note> noteList = new ArrayList<Note>();

        @Override
        public int getCount(){
            return noteList.size();
        }
        @Override
        public Note getItem(int whichItem){
            return noteList.get(whichItem);
        }
        @Override
        public long getItemId(int whichItem){
            return whichItem;
        }
        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup){
            //implement this method next
            //Has view been inflated already
            if (view == null){
                //If not, do so here
                //first create a LayoutInflater
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //Now instantiate view using inflater.inflate
                //using the listitem layout
                view = inflater.inflate(R.layout.listitem, viewGroup, false);
                //the false parameter is necessary, because of the way we want to use listitem
            } //End if

            //grab a reference to all TextView and ImageView widgets
            TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);
            ImageView ivImportant = (ImageView) view.findViewById(R.id.imageViewImportant);
            ImageView ivTodo = (ImageView) view.findViewById(R.id.imageViewTodo);
            ImageView ivIdea = (ImageView) view.findViewById(R.id.imageViewData);

            //hide image view widges that aren't relevant
            Note tempNote = noteList.get(whichItem);

            if (!tempNote.isImportant()){
                ivImportant.setVisibility(View.GONE);
            }
            if (!tempNote.isTodo()){
                ivTodo.setVisibility(View.GONE);
            }
            if (!tempNote.isIdea()){
                ivIdea.setVisibility(View.GONE);
            }

            //add text to the heading and description
            txtTitle.setText(tempNote.getTitle());
            txtDescription.setText(tempNote.getDescription());
            return view;
        }
        public void addNote(Note n){
            noteList.add(n);
            notifyDataSetChanged();
        }
    } //end of NoteAdapter
} //end of Main Activity
