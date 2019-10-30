/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.NoteDB;
import java.util.Date;
import java.util.List;
import models.Note;

/**
 *
 * @author 652343
 */
public class NoteService
  {

    public Note get(int noteid)
      {
        NoteDB ndb = new NoteDB();
        Note note = ndb.get(noteid);
        return note;
      }

    public List<Note> getAll()
      {
        NoteDB ndb = new NoteDB();
        List<Note> notes = ndb.getAll();
        return notes;
      }
    
    public void update(int noteid, String title, String contents)
      {
        NoteDB ndb = new NoteDB();
        Note note = ndb.get(noteid);
        note.setTitle(title);
        note.setContents(contents);
        ndb.update(note);
      }
    
        
    public void delete(int noteid)
      {
        NoteDB ndb = new NoteDB();
        Note note = ndb.get(noteid);
        ndb.delete(note);
      }
    
    public void insert(String contents, String title)
      {
        NoteDB ndb = new NoteDB();
        Date d = new Date();
        Note note = new Note(0,d,title,contents);
        ndb.insert(note);
      }
  }
