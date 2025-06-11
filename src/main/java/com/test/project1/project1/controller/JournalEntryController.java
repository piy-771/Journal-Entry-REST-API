package com.test.project1.project1.controller;

import com.test.project1.project1.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Integer, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getJournalEntries(){     //http://localhost:8080/journal  Method:GET
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){      //http://localhost:8080/journal   Method:POST
        journalEntries.put(entry.getId(),entry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Integer myId){           //http://localhost:8080/journal/id/your_id  Method : GET
        return journalEntries.get(myId);
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Integer myId){             //http://localhost:8080/journal/id/your_id   Method : DELETE
        return journalEntries.remove(myId);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Integer id,@RequestBody JournalEntry myEntry){          //http://localhost:8080/journal/id/your_id   Method: PUT
        return journalEntries.put(id,myEntry);
    }
}
