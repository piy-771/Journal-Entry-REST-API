package com.test.project1.project1.controller;

import com.test.project1.project1.entity.JournalEntry;
import com.test.project1.project1.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getJournalEntries(){     //http://localhost:8080/journal  Method:GET
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry){//http://localhost:8080/journal   Method:POST
        entry.setData(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return entry;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){           //http://localhost:8080/journal/id/your_id  Method : GET
        return journalEntryService.getById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId){             //http://localhost:8080/journal/id/your_id   Method : DELETE
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id,@RequestBody JournalEntry myEntry){          //http://localhost:8080/journal/id/your_id   Method: PUT
        JournalEntry oldEntry = journalEntryService.getById(id).orElse(null);
        if(oldEntry != null){
            oldEntry.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals("")? myEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(myEntry.getContent() != null && !myEntry.getContent().equals("") ? myEntry.getContent() : oldEntry.getContent());
        }
        journalEntryService.saveEntry(oldEntry);
        return oldEntry;
    }
}
