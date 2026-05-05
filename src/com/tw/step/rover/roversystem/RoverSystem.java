package com.tw.step.rover.roversystem;

import com.tw.step.rover.commands.RoverCommands;
import com.tw.step.rover.rover.Rover;

import java.util.ArrayList;
import java.util.HashMap;

public class RoverSystem {
  HashMap<String, Rover> rovers = new HashMap<>();
  HashMap<String, RoverCommands> roversCommands = new HashMap<>();
  ArrayList<String> roversOrder = new ArrayList<>();

  public void addRover(String roverId, Rover rover) {
    rovers.put(roverId, rover);
    roversOrder.add(roverId);
  }

  public void addCommands(String roverId, RoverCommands roverCommands) {
    roversCommands.put(roverId, roverCommands);
  }

  public void execute() {
    for (String roverId : roversOrder) {
      RoverCommands roverCommands = this.roversCommands.get(roverId);
      Rover rover = this.rovers.get(roverId);
      roverCommands.execute(rover);
    }
  }

  @Override
  public String toString() {
    return roversOrder.stream()
            .map(id -> rovers.get(id).toString())
            .reduce((r1, r2) -> r1 + "\n" + r2)
            .orElse("");
  }
}
