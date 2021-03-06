package com.example.finalprojectdeploy.services;

import com.example.finalprojectdeploy.model.HistoryAction;
import com.example.finalprojectdeploy.repositories.HistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

  @Autowired
  HistoryRepository historyRepository;

  public List<HistoryAction> findRecentHistory() {
    List<HistoryAction> history = historyRepository.findRecentHistory();
    return history.size() > 20 ? history.subList(0, 20) : history;
  }

  public HistoryAction createHistoryAction(HistoryAction action) {
    return historyRepository.save(action);
  }
}
