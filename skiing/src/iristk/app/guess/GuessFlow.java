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
			// Line: 14
			try {
				EXECUTION: {
					int count = getCount(1285044316) + 1;
					incrCount(1285044316);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Hello, shall we start?");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 14, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 14, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 14, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 19
			try {
				count = getCount(1811075214) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1811075214);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 20
							ran = new Random();
							// Line: 21
							data = new Integer[5][7];
							// Line: 22
							days = new String[7];
							// Line: 23
							locations = new String[5];
							// Line: 24
							{
								RepeatHandler i = new RepeatHandler(5);
								while (i.getPosition() < i.getLength()) {
									// Line: 25
									{
										RepeatHandler j = new RepeatHandler(7);
										while (j.getPosition() < j.getLength()) {
											// Line: 27
											data[i.getPosition()][j.getPosition()] = new Integer(ran.nextInt(3));
											j.next();
										}
									}
									i.next();
								}
							}
							// Line: 30
							locations[0] = new String("Arizona Snowbowl");
							locations[1] = new String("Bear Mountain");
							locations[2] = new String("Bear Valley");
							locations[3] = new String("Big Boulder");
							locations[4] = new String("Bogus Basin");
							// Line: 36
							days[0] = new String("Monday");
							days[1] = new String("Tuesday");
							days[2] = new String("Wednesday");
							days[3] = new String("Thursday");
							days[4] = new String("Friday");
							days[5] = new String("Saturday");
							days[6] = new String("Sunday");
							// Line: 43
							Where state3 = new Where();
							flowThread.gotoState(state3, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 43, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 19, 58));
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
			// Line: 49
			try {
				EXECUTION: {
					int count = getCount(1143839598) + 1;
					incrCount(1143839598);
					iristk.flow.DialogFlow.say state4 = new iristk.flow.DialogFlow.say();
					StringCreator string5 = new StringCreator();
					string5.append("Where do you want to go?");
					state4.setText(string5.toString());
					if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 49, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state6 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 49, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 49, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 53
			try {
				count = getCount(250075633) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:loc")) {
						incrCount(250075633);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 54
							final_loc = (Integer)event.get("sem:loc");
							iristk.flow.DialogFlow.say state7 = new iristk.flow.DialogFlow.say();
							StringCreator string8 = new StringCreator();
							string8.append("The weather is great for skiing on the following days:");
							state7.setText(string8.toString());
							if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 53, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 56
							{
								RepeatHandler d = new RepeatHandler(7);
								while (d.getPosition() < d.getLength()) {
									// Line: 57
									if (data[(Integer)event.get("sem:loc")][d.getPosition()] == 2) {
										iristk.flow.DialogFlow.say state9 = new iristk.flow.DialogFlow.say();
										StringCreator string10 = new StringCreator();
										// Line: 57
										string10.append(days[d.getPosition()]);
										state9.setText(string10.toString());
										if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 57, 67)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
									d.next();
								}
							}
							// Line: 62
							Pick_Date state11 = new Pick_Date();
							flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 62, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 53, 58));
			}
			// Line: 66
			try {
				count = getCount(425918570) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:dontKnow")) {
						incrCount(425918570);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 67
							When state12 = new When();
							flowThread.gotoState(state12, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 67, 23)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 66, 63));
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
			// Line: 72
			try {
				EXECUTION: {
					int count = getCount(204349222) + 1;
					incrCount(204349222);
					iristk.flow.DialogFlow.say state13 = new iristk.flow.DialogFlow.say();
					StringCreator string14 = new StringCreator();
					string14.append("Please pick a date, Otherwise shall I suggest another location?");
					state13.setText(string14.toString());
					if (!flowThread.callState(state13, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 72, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state15 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 72, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 72, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 76
			try {
				count = getCount(114935352) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:day")) {
						incrCount(114935352);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 77
							final_date = (Integer)event.get("sem:day");
							// Line: 78
							Final state16 = new Final();
							flowThread.gotoState(state16, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 78, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 76, 58));
			}
			// Line: 80
			try {
				count = getCount(1973538135) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1973538135);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 81
							When state17 = new When();
							flowThread.gotoState(state17, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 81, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 80, 58));
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
			// Line: 86
			try {
				EXECUTION: {
					int count = getCount(515132998) + 1;
					incrCount(515132998);
					iristk.flow.DialogFlow.say state18 = new iristk.flow.DialogFlow.say();
					StringCreator string19 = new StringCreator();
					string19.append("Pick a day for the next week, please!");
					state18.setText(string19.toString());
					if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 86, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state20 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 86, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 86, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 90
			try {
				count = getCount(1694819250) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:day")) {
						incrCount(1694819250);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 91
							final_date = (Integer)event.get("sem:day");
							iristk.flow.DialogFlow.say state21 = new iristk.flow.DialogFlow.say();
							StringCreator string22 = new StringCreator();
							string22.append("On");
							// Line: 91
							string22.append(days[final_date]);
							string22.append("the weather would be great for skiing at the following locations:");
							state21.setText(string22.toString());
							if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 90, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 93
							{
								RepeatHandler l = new RepeatHandler(5);
								while (l.getPosition() < l.getLength()) {
									// Line: 94
									if (data[l.getPosition()][(Integer)event.get("sem:day")] == 2) {
										iristk.flow.DialogFlow.say state23 = new iristk.flow.DialogFlow.say();
										StringCreator string24 = new StringCreator();
										// Line: 94
										string24.append(locations[l.getPosition()]);
										state23.setText(string24.toString());
										if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 94, 67)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
									l.next();
								}
							}
							// Line: 98
							Pick_location state25 = new Pick_location();
							flowThread.gotoState(state25, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 98, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 90, 58));
			}
			// Line: 100
			try {
				count = getCount(932583850) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(932583850);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 101
							When state26 = new When();
							flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 101, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 100, 58));
			}
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
			// Line: 106
			try {
				EXECUTION: {
					int count = getCount(359023572) + 1;
					incrCount(359023572);
					iristk.flow.DialogFlow.say state27 = new iristk.flow.DialogFlow.say();
					StringCreator string28 = new StringCreator();
					string28.append("Please pick a location, Otherwise do you want to consider another day?");
					state27.setText(string28.toString());
					if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 106, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state29 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 106, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 106, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 110
			try {
				count = getCount(305808283) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:loc")) {
						incrCount(305808283);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 111
							final_loc = (Integer)event.get("sem:loc");
							// Line: 112
							Final state30 = new Final();
							flowThread.gotoState(state30, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 112, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 110, 58));
			}
			// Line: 114
			try {
				count = getCount(917142466) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(917142466);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 115
							When state31 = new When();
							flowThread.gotoState(state31, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 115, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 114, 58));
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
			// Line: 120
			try {
				EXECUTION: {
					int count = getCount(653305407) + 1;
					incrCount(653305407);
					iristk.flow.DialogFlow.say state32 = new iristk.flow.DialogFlow.say();
					StringCreator string33 = new StringCreator();
					string33.append("Do you have any further questions?");
					state32.setText(string33.toString());
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state34 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 120, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 125
			try {
				count = getCount(1404928347) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1404928347);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state35 = new iristk.flow.DialogFlow.say();
						StringCreator string36 = new StringCreator();
						string36.append("Okay, goodbye");
						state35.setText(string36.toString());
						if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 125, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 127
						System.exit(0);
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 125, 36));
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
			// Line: 132
			try {
				count = getCount(1227229563) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1227229563);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state37 = new iristk.flow.DialogFlow.say();
						StringCreator string38 = new StringCreator();
						string38.append("I am sorry, I didn't hear anything.");
						state37.setText(string38.toString());
						if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 132, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 134
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 134, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 132, 38));
			}
			// Line: 136
			try {
				count = getCount(1562557367) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1562557367);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state39 = new iristk.flow.DialogFlow.say();
						StringCreator string40 = new StringCreator();
						string40.append("I am sorry, I didn't get that.");
						state39.setText(string40.toString());
						if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 136, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 138
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 138, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\Downloads\\IrisTK-master\\IrisTK-master\\app\\guess\\src\\iristk\\app\\guess\\GuessFlow.xml"), 136, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
