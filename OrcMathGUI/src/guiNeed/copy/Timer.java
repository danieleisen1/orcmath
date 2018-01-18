package guiNeed.copy;

import guiTeacher.components.Action;
import guiTeacher.components.Component;
import guiTeacher.components.TextLabel;

public class Timer implements Runnable {
	private long startTime;
	private int duration;
	private Action action;
	private TextLabel text;
	public Timer(TextLabel text, long startTime, int duration, Action action) {
		this.startTime = startTime;
		this.duration = duration;
		this.action = action;
		this.text = text;
	}

	@Override
	public void run() {
		while (System.nanoTime() - startTime <= duration * 1E9) {
			text.setText(String.valueOf(duration - (int)((System.nanoTime() - startTime) / 1E9)));
		}
		action.act();
	}

}



