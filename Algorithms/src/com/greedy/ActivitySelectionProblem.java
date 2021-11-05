package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelectionProblem {

	 
	public static void main(String[] args) {
		
		System.out.println(
				getSelectedTasks(Arrays.asList(new Task(1,4),new Task(0, 6) ,new Task(6, 10)
						 ,new Task(3, 8),new Task(5, 9),new Task(8, 11),new Task(2, 13),
						 new Task(8, 12), new Task(5, 7), new Task(12, 14),new Task(3, 5)
						 ))
				);

	}
	
	private static List<Task> getSelectedTasks(List<Task> tasks){
		List<Task> selectedTasks = new ArrayList<Task>();
		
		Collections.sort(tasks, Comparator.comparingInt(Task::getEnd));
		
		int lastTaskEndTime = -1;
		for(Task task:tasks) {
			
			if(lastTaskEndTime == -1 || task.getStart() > lastTaskEndTime) {
				selectedTasks.add(task);
				lastTaskEndTime = task.getEnd();
			}
		}
		
		return selectedTasks;
	}

}


class Task{
	
	private int start ;
	private int end;
	
	
	public Task(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	@Override
	public String toString() {
		return "Task [start=" + start + ", end=" + end + "]";
	}
	
	
	
}
