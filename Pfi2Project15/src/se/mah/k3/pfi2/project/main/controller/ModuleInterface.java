package se.mah.k3.pfi2.project.main.controller;

public interface ModuleInterface {
	/** All modules are ordered out of priority and all doesn't fit at all times
	 * The module is expected to respect the rules
	 * @return priority An integer from 1 - 10.
	 * 1 = Crucial
	 * 5 = If room
	 * 9 = Entertaiment module
	 * 10 = Screensaver module when the screens are idle
	 */
	public int getExpectedPriority();
	/**
	 * @return rows The optimal number of rows for the module
	 */
	public int getPreferdNumberOfRows();
	/**
	 * @return rows The minimum number of rows for the module
	 */
	public int getMinNumberOfRows();
	/** In an multiscreen environment one part can be shown on one screen and the other on next.
	 * @param start the first rownumber to show (starts from zero)
	 * @param end the last rownumber to show (starts from zero)
	 * @return booblen rows if the module is split on two screens t
	 */
	public boolean showNumberOfRows(int start, int end);
	public void repaint();
}

