package iristk.app.guess;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;
import java.util.Random;

public class GuessFlow extends iristk.flow.Flow {

	private Integer[][] data;
	private Random ran;
	private String[] days;
	private String[] quality;
	private String[] locations;
	private Integer final_loc;
	private Integer final_date;

	private void initVariables() {
	}

	public Integer[][] getData() {
		return this.data;
	}

	public void setData(Integer[][] value) {
		this.data = value;
	}

	public Random getRan() {
		return this.ran;
	}

	public void setRan(Random value) {
		this.ran = value;
	}

	public String[] getDays() {
		return this.days;
	}

	public void setDays(String[] value) {
		this.days = value;
	}

	public String[] getQuality() {
		return this.quality;
	}

	public void setQuality(String[] value) {
		this.quality = value;
	}

	public String[] getLocations() {
		return this.locations;
	}

	public void setLocations(String[] value) {
		this.locations = value;
	}

	public Integer getFinal_loc() {
		return this.final_loc;
	}

	public void setFinal_loc(Integer value) {
		this.final_loc = value;
	}

	public Integer getFinal_date() {
		return this.final_date;
	}

	public void setFinal_date(Integer value) {
		this.final_date = value;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("data")) return this.data;
		if (name.equals("ran")) return this.ran;
		if (name.equals("days")) return this.days;
		if (name.equals("quality")) return this.quality;
		if (name.equals("locations")) return this.locations;
		if (name.equals("final_loc")) return this.final_loc;
		if (name.equals("final_date")) return this.final_date;
		return null;
	}


	public GuessFlow() {
		initVariables();
	}

	@Override
	public State getInitialState() {return new Start();}


	public class Start extends State implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 15
			try {
				EXECUTION: {
					int count = getCount(1607460018) + 1;
					incrCount(1607460018);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Hello, shall we start?");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 15, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 15, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 15, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 19
			try {
				count = getCount(1588970020) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1588970020);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 20
							Final state3 = new Final();
							flowThread.gotoState(state3, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 20, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 19, 57));
			}
			// Line: 22
			try {
				count = getCount(1940447180) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1940447180);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 23
							ran = new Random();
							// Line: 24
							data = new Integer[5][7];
							// Line: 25
							days = new String[7];
							// Line: 26
							quality = new String[3];
							// Line: 27
							locations = new String[5];
							// Line: 28
							final_date = -1;
							// Line: 29
							final_loc = -1;
							// Line: 31
							{
								RepeatHandler i = new RepeatHandler(5);
								while (i.getPosition() < i.getLength()) {
									// Line: 32
									{
										RepeatHandler j = new RepeatHandler(7);
										while (j.getPosition() < j.getLength()) {
											// Line: 33
											data[i.getPosition()][j.getPosition()] = new Integer(ran.nextInt(3));
											j.next();
										}
									}
									i.next();
								}
							}
							// Line: 37
							locations[0] = new String("Arizona Snowbowl");
							locations[1] = new String("Bear Mountain");
							locations[2] = new String("Bear Valley");
							locations[3] = new String("Big Boulder");
							locations[4] = new String("Bogus Basin");
							// Line: 44
							days[0] = new String("Monday");
							days[1] = new String("Tuesday");
							days[2] = new String("Wednesday");
							days[3] = new String("Thursday");
							days[4] = new String("Friday");
							days[5] = new String("Saturday");
							days[6] = new String("Sunday");
							// Line: 53
							quality[0] = new String("Unusable");
							quality[1] = new String("Okay");
							quality[2] = new String("Great");
							// Line: 58
							Where state4 = new Where();
							flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 58, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 22, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Where extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 64
			try {
				EXECUTION: {
					int count = getCount(2143192188) + 1;
					incrCount(2143192188);
					iristk.flow.DialogFlow.say state5 = new iristk.flow.DialogFlow.say();
					StringCreator string6 = new StringCreator();
					string6.append("Where do you want to go?");
					state5.setText(string6.toString());
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 64, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state7 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 64, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 64, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 69
			try {
				count = getCount(1100439041) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:loc") && event.has("sem:day")) {
						incrCount(1100439041);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 70
							final_loc = (Integer)event.get("sem:loc");
							// Line: 71
							final_date = (Integer)event.get("sem:day");
							// Line: 72
							if (data[final_loc][final_date] == 2) {
								iristk.flow.DialogFlow.say state8 = new iristk.flow.DialogFlow.say();
								StringCreator string9 = new StringCreator();
								string9.append("The snow conditions for this day are Great. Have Fun.");
								state8.setText(string9.toString());
								if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 72, 48)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 74
								Final state10 = new Final();
								flowThread.gotoState(state10, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 74, 26)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 76
							if (data[final_loc][final_date] == 1) {
								iristk.flow.DialogFlow.say state11 = new iristk.flow.DialogFlow.say();
								StringCreator string12 = new StringCreator();
								string12.append("The snow conditions for this day are Okay but not Great.");
								state11.setText(string12.toString());
								if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 76, 48)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 78
								Confirm state13 = new Confirm();
								flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 78, 28)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 80
							if (data[final_loc][final_date] == 0) {
								iristk.flow.DialogFlow.say state14 = new iristk.flow.DialogFlow.say();
								StringCreator string15 = new StringCreator();
								string15.append("The won't be enough snow on this day to go skiing.");
								state14.setText(string15.toString());
								if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 80, 48)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 82
								ChangeDateOrLoc state16 = new ChangeDateOrLoc();
								flowThread.gotoState(state16, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 82, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 69, 77));
			}
			// Line: 86
			try {
				count = getCount(515132998) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:loc")) {
						incrCount(515132998);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 87
							final_loc = (Integer)event.get("sem:loc");
							// Line: 88
							SuggestDay state17 = new SuggestDay();
							flowThread.gotoState(state17, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 88, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 86, 58));
			}
			// Line: 91
			try {
				count = getCount(1586600255) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:dontKnow")) {
						incrCount(1586600255);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 92
							When state18 = new When();
							flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 92, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 91, 63));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class When extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 97
			try {
				EXECUTION: {
					int count = getCount(212628335) + 1;
					incrCount(212628335);
					iristk.flow.DialogFlow.say state19 = new iristk.flow.DialogFlow.say();
					StringCreator string20 = new StringCreator();
					string20.append("Pick a day for the next week, please!");
					state19.setText(string20.toString());
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 97, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state21 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 97, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 97, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 101
			try {
				count = getCount(1579572132) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:day")) {
						incrCount(1579572132);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 102
							final_date = (Integer)event.get("sem:day");
							// Line: 103
							SuggestLocation state22 = new SuggestLocation();
							flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 103, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 101, 58));
			}
			// Line: 105
			try {
				count = getCount(2111991224) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(2111991224);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 106
							When state23 = new When();
							flowThread.gotoState(state23, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 106, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 105, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class SuggestLocation extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 111
			try {
				EXECUTION: {
					int count = getCount(1993134103) + 1;
					incrCount(1993134103);
					iristk.flow.DialogFlow.say state24 = new iristk.flow.DialogFlow.say();
					StringCreator string25 = new StringCreator();
					string25.append("On");
					// Line: 111
					string25.append(days[final_date]);
					string25.append("the weather would be great for skiing at the following locations:");
					state24.setText(string25.toString());
					if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 111, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 113
					{
						RepeatHandler l = new RepeatHandler(5);
						while (l.getPosition() < l.getLength()) {
							// Line: 114
							if (data[l.getPosition()][(Integer)event.get("sem:day")] == 2) {
								iristk.flow.DialogFlow.say state26 = new iristk.flow.DialogFlow.say();
								StringCreator string27 = new StringCreator();
								// Line: 114
								string27.append(locations[l.getPosition()]);
								state26.setText(string27.toString());
								if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 114, 67)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
							l.next();
						}
					}
					// Line: 118
					Pick_location state28 = new Pick_location();
					flowThread.gotoState(state28, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 118, 33)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 111, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class SuggestDay extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 123
			try {
				EXECUTION: {
					int count = getCount(604107971) + 1;
					incrCount(604107971);
					iristk.flow.DialogFlow.say state29 = new iristk.flow.DialogFlow.say();
					StringCreator string30 = new StringCreator();
					string30.append("The weather is great for skiing on the following days:");
					state29.setText(string30.toString());
					if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 125
					{
						RepeatHandler d = new RepeatHandler(7);
						while (d.getPosition() < d.getLength()) {
							// Line: 126
							if (data[(Integer)event.get("sem:loc")][d.getPosition()] == 2) {
								iristk.flow.DialogFlow.say state31 = new iristk.flow.DialogFlow.say();
								StringCreator string32 = new StringCreator();
								// Line: 126
								string32.append(days[d.getPosition()]);
								state31.setText(string32.toString());
								if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 126, 67)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
							d.next();
						}
					}
					// Line: 131
					Pick_Date state33 = new Pick_Date();
					flowThread.gotoState(state33, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 131, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 123, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Pick_location extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 136
			try {
				EXECUTION: {
					int count = getCount(1101288798) + 1;
					incrCount(1101288798);
					iristk.flow.DialogFlow.say state34 = new iristk.flow.DialogFlow.say();
					StringCreator string35 = new StringCreator();
					string35.append("Please pick a location, Otherwise do you want to consider another day?");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 136, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state36 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 136, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 136, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 140
			try {
				count = getCount(971848845) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:loc")) {
						incrCount(971848845);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 141
							final_loc = (Integer)event.get("sem:loc");
							// Line: 142
							Final state37 = new Final();
							flowThread.gotoState(state37, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 142, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 140, 58));
			}
			// Line: 144
			try {
				count = getCount(2104457164) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(2104457164);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 145
							if (final_loc != -1) {
								// Line: 146
								SuggestDay state38 = new SuggestDay();
								flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 146, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 148
							When state39 = new When();
							flowThread.gotoState(state39, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 148, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 144, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Pick_Date extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 153
			try {
				EXECUTION: {
					int count = getCount(1617791695) + 1;
					incrCount(1617791695);
					iristk.flow.DialogFlow.say state40 = new iristk.flow.DialogFlow.say();
					StringCreator string41 = new StringCreator();
					string41.append("Please pick a date, Otherwise shall I suggest another location?");
					state40.setText(string41.toString());
					if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 153, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state42 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 153, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 153, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 157
			try {
				count = getCount(1192108080) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:day")) {
						incrCount(1192108080);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 158
							final_date = (Integer)event.get("sem:day");
							// Line: 159
							Final state43 = new Final();
							flowThread.gotoState(state43, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 159, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 157, 58));
			}
			// Line: 161
			try {
				count = getCount(537548559) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(537548559);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 162
							if (final_date != -1) {
								// Line: 163
								SuggestLocation state44 = new SuggestLocation();
								flowThread.gotoState(state44, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 163, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 165
							Where state45 = new Where();
							flowThread.gotoState(state45, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 165, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 161, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Change_Location extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 170
			try {
				EXECUTION: {
					int count = getCount(992136656) + 1;
					incrCount(992136656);
					iristk.flow.DialogFlow.say state46 = new iristk.flow.DialogFlow.say();
					StringCreator string47 = new StringCreator();
					string47.append("Please pick a new Location.");
					state46.setText(string47.toString());
					if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 170, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state48 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 170, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 170, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 174
			try {
				count = getCount(511833308) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:loc")) {
						incrCount(511833308);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 175
							final_loc = (Integer)event.get("sem:loc");
							// Line: 176
							if (data[final_loc][final_date] == 2) {
								iristk.flow.DialogFlow.say state49 = new iristk.flow.DialogFlow.say();
								StringCreator string50 = new StringCreator();
								string50.append("The snow conditions for this day are Great. Have Fun.");
								state49.setText(string50.toString());
								if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 176, 48)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 178
								Final state51 = new Final();
								flowThread.gotoState(state51, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 178, 26)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 180
							if (data[final_loc][final_date] == 1) {
								iristk.flow.DialogFlow.say state52 = new iristk.flow.DialogFlow.say();
								StringCreator string53 = new StringCreator();
								string53.append("The snow conditions for this day are Okay but not Great.");
								state52.setText(string53.toString());
								if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 180, 48)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 182
								Confirm state54 = new Confirm();
								flowThread.gotoState(state54, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 182, 28)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 184
							if (data[final_loc][final_date] == 0) {
								iristk.flow.DialogFlow.say state55 = new iristk.flow.DialogFlow.say();
								StringCreator string56 = new StringCreator();
								string56.append("The won't be enough snow on this day to go skiing.");
								state55.setText(string56.toString());
								if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 184, 48)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 186
								ChangeDateOrLoc state57 = new ChangeDateOrLoc();
								flowThread.gotoState(state57, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 186, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 174, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Change_Day extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 192
			try {
				EXECUTION: {
					int count = getCount(1552787810) + 1;
					incrCount(1552787810);
					iristk.flow.DialogFlow.say state58 = new iristk.flow.DialogFlow.say();
					StringCreator string59 = new StringCreator();
					string59.append("Please pick a new Date.");
					state58.setText(string59.toString());
					if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 192, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state60 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state60, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 192, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 192, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 196
			try {
				count = getCount(1361960727) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:day")) {
						incrCount(1361960727);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 197
							final_loc = (Integer)event.get("sem:loc");
							// Line: 198
							if (data[final_loc][final_date] == 2) {
								iristk.flow.DialogFlow.say state61 = new iristk.flow.DialogFlow.say();
								StringCreator string62 = new StringCreator();
								string62.append("The snow conditions for this day are Great. Have Fun.");
								state61.setText(string62.toString());
								if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 198, 48)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 200
								Final state63 = new Final();
								flowThread.gotoState(state63, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 200, 26)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 202
							if (data[final_loc][final_date] == 1) {
								iristk.flow.DialogFlow.say state64 = new iristk.flow.DialogFlow.say();
								StringCreator string65 = new StringCreator();
								string65.append("The snow conditions for this day are Okay but not Great.");
								state64.setText(string65.toString());
								if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 202, 48)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 204
								Confirm state66 = new Confirm();
								flowThread.gotoState(state66, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 204, 28)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 206
							if (data[final_loc][final_date] == 0) {
								iristk.flow.DialogFlow.say state67 = new iristk.flow.DialogFlow.say();
								StringCreator string68 = new StringCreator();
								string68.append("The won't be enough snow on this day to go skiing.");
								state67.setText(string68.toString());
								if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 206, 48)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 208
								ChangeDateOrLoc state69 = new ChangeDateOrLoc();
								flowThread.gotoState(state69, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 208, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 196, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Confirm extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 214
			try {
				EXECUTION: {
					int count = getCount(248609774) + 1;
					incrCount(248609774);
					iristk.flow.DialogFlow.say state70 = new iristk.flow.DialogFlow.say();
					StringCreator string71 = new StringCreator();
					string71.append("Is this good enough?");
					state70.setText(string71.toString());
					if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 214, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state72 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state72, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 214, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 214, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 219
			try {
				count = getCount(708049632) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(708049632);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state73 = new iristk.flow.DialogFlow.say();
							StringCreator string74 = new StringCreator();
							string74.append("Okay, goodbye");
							state73.setText(string74.toString());
							if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 219, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 221
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 219, 58));
			}
			// Line: 223
			try {
				count = getCount(285377351) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(285377351);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 224
							ChangeDateOrLoc state75 = new ChangeDateOrLoc();
							flowThread.gotoState(state75, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 224, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 223, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class ChangeDateOrLoc extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 229
			try {
				EXECUTION: {
					int count = getCount(716083600) + 1;
					incrCount(716083600);
					iristk.flow.DialogFlow.say state76 = new iristk.flow.DialogFlow.say();
					StringCreator string77 = new StringCreator();
					string77.append("Would you like change the Date, Location or start from the beginning?");
					state76.setText(string77.toString());
					if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 229, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state78 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 229, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 229, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 234
			try {
				count = getCount(2001112025) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:cday")) {
						incrCount(2001112025);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 235
							final_date = -1;
							// Line: 236
							SuggestDay state79 = new SuggestDay();
							flowThread.gotoState(state79, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 236, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 234, 59));
			}
			// Line: 238
			try {
				count = getCount(2054881392) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:cloc")) {
						incrCount(2054881392);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 239
							final_loc = -1;
							// Line: 240
							SuggestLocation state80 = new SuggestLocation();
							flowThread.gotoState(state80, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 240, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 238, 59));
			}
			// Line: 242
			try {
				count = getCount(116211441) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:start")) {
						incrCount(116211441);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 243
							Where state81 = new Where();
							flowThread.gotoState(state81, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 243, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 242, 60));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Final extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 248
			try {
				EXECUTION: {
					int count = getCount(242481580) + 1;
					incrCount(242481580);
					iristk.flow.DialogFlow.say state82 = new iristk.flow.DialogFlow.say();
					StringCreator string83 = new StringCreator();
					string83.append("Do you want to check another day or location?");
					state82.setText(string83.toString());
					if (!flowThread.callState(state82, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 248, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state84 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state84, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 248, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 248, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 253
			try {
				count = getCount(1627800613) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1627800613);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 254
							Where state85 = new Where();
							flowThread.gotoState(state85, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 254, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 253, 58));
			}
			// Line: 257
			try {
				count = getCount(697960108) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(697960108);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state86 = new iristk.flow.DialogFlow.say();
						StringCreator string87 = new StringCreator();
						string87.append("Okay, goodbye");
						state86.setText(string87.toString());
						if (!flowThread.callState(state86, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 257, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 259
						System.exit(0);
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 257, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 264
			try {
				count = getCount(2066940133) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(2066940133);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state88 = new iristk.flow.DialogFlow.say();
						StringCreator string89 = new StringCreator();
						string89.append("I am sorry, I didn't hear anything.");
						state88.setText(string89.toString());
						if (!flowThread.callState(state88, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 264, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 266
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 266, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 264, 38));
			}
			// Line: 268
			try {
				count = getCount(325333723) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(325333723);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state90 = new iristk.flow.DialogFlow.say();
						StringCreator string91 = new StringCreator();
						string91.append("I am sorry, I didn't get that.");
						state90.setText(string91.toString());
						if (!flowThread.callState(state90, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 268, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 270
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 270, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\git\\IrisTK\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 268, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
