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
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 14, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 14, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 14, 12));
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
							flowThread.gotoState(state3, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 43, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 19, 58));
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
					if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 49, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state6 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 49, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 49, 12));
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
							if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 53, 58)))) {
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
										if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 57, 67)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
									d.next();
								}
							}
							// Line: 62
							Pick_Date state11 = new Pick_Date();
							flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 62, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 53, 58));
			}
			// Line: 65
			try {
				count = getCount(425918570) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:loc") && event.has("sem:day")) {
						incrCount(425918570);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 66
							final_loc = (Integer)event.get("sem:loc");
							iristk.flow.DialogFlow.say state12 = new iristk.flow.DialogFlow.say();
							StringCreator string13 = new StringCreator();
							string13.append("The weather for this day is");
							state12.setText(string13.toString());
							if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 65, 77)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 69
							Pick_Date state14 = new Pick_Date();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 69, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 65, 77));
			}
			// Line: 74
			try {
				count = getCount(204349222) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:dontKnow")) {
						incrCount(204349222);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 75
							When state15 = new When();
							flowThread.gotoState(state15, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 75, 23)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 74, 63));
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
			// Line: 80
			try {
				EXECUTION: {
					int count = getCount(2110121908) + 1;
					incrCount(2110121908);
					iristk.flow.DialogFlow.say state16 = new iristk.flow.DialogFlow.say();
					StringCreator string17 = new StringCreator();
					string17.append("Please pick a date, Otherwise shall I suggest another location?");
					state16.setText(string17.toString());
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 80, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state18 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 80, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 80, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 84
			try {
				count = getCount(1973538135) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:day")) {
						incrCount(1973538135);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 85
							final_date = (Integer)event.get("sem:day");
							// Line: 86
							Final state19 = new Final();
							flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 86, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 84, 58));
			}
			// Line: 88
			try {
				count = getCount(515132998) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(515132998);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 89
							When state20 = new When();
							flowThread.gotoState(state20, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 89, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 88, 58));
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
			// Line: 94
			try {
				EXECUTION: {
					int count = getCount(1651191114) + 1;
					incrCount(1651191114);
					iristk.flow.DialogFlow.say state21 = new iristk.flow.DialogFlow.say();
					StringCreator string22 = new StringCreator();
					string22.append("Pick a day for the next week, please!");
					state21.setText(string22.toString());
					if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 94, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state23 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 94, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 94, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 98
			try {
				count = getCount(1586600255) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:day")) {
						incrCount(1586600255);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 99
							final_date = (Integer)event.get("sem:day");
							iristk.flow.DialogFlow.say state24 = new iristk.flow.DialogFlow.say();
							StringCreator string25 = new StringCreator();
							string25.append("On");
							// Line: 99
							string25.append(days[final_date]);
							string25.append("the weather would be great for skiing at the following locations:");
							state24.setText(string25.toString());
							if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 98, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 101
							{
								RepeatHandler l = new RepeatHandler(5);
								while (l.getPosition() < l.getLength()) {
									// Line: 102
									if (data[l.getPosition()][(Integer)event.get("sem:day")] == 2) {
										iristk.flow.DialogFlow.say state26 = new iristk.flow.DialogFlow.say();
										StringCreator string27 = new StringCreator();
										// Line: 102
										string27.append(locations[l.getPosition()]);
										state26.setText(string27.toString());
										if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 102, 67)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
									l.next();
								}
							}
							// Line: 106
							Pick_location state28 = new Pick_location();
							flowThread.gotoState(state28, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 106, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 98, 58));
			}
			// Line: 108
			try {
				count = getCount(359023572) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(359023572);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 109
							When state29 = new When();
							flowThread.gotoState(state29, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 109, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 108, 58));
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
			// Line: 114
			try {
				EXECUTION: {
					int count = getCount(292938459) + 1;
					incrCount(292938459);
					iristk.flow.DialogFlow.say state30 = new iristk.flow.DialogFlow.say();
					StringCreator string31 = new StringCreator();
					string31.append("Please pick a location, Otherwise do you want to consider another day?");
					state30.setText(string31.toString());
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 114, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state32 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 114, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 114, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 118
			try {
				count = getCount(1993134103) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:loc")) {
						incrCount(1993134103);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 119
							final_loc = (Integer)event.get("sem:loc");
							// Line: 120
							Final state33 = new Final();
							flowThread.gotoState(state33, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 120, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 118, 58));
			}
			// Line: 122
			try {
				count = getCount(1130478920) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1130478920);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 123
							When state34 = new When();
							flowThread.gotoState(state34, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 123, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 122, 58));
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
			// Line: 128
			try {
				EXECUTION: {
					int count = getCount(123961122) + 1;
					incrCount(123961122);
					iristk.flow.DialogFlow.say state35 = new iristk.flow.DialogFlow.say();
					StringCreator string36 = new StringCreator();
					string36.append("Do you have any further questions?");
					state35.setText(string36.toString());
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 128, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state37 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 128, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 128, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 133
			try {
				count = getCount(1982791261) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1982791261);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state38 = new iristk.flow.DialogFlow.say();
						StringCreator string39 = new StringCreator();
						string39.append("Okay, goodbye");
						state38.setText(string39.toString());
						if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 133, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 135
						System.exit(0);
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 133, 36));
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
			// Line: 140
			try {
				count = getCount(942731712) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(942731712);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state40 = new iristk.flow.DialogFlow.say();
						StringCreator string41 = new StringCreator();
						string41.append("I am sorry, I didn't hear anything.");
						state40.setText(string41.toString());
						if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 140, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 142
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 142, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 140, 38));
			}
			// Line: 144
			try {
				count = getCount(1910163204) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1910163204);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state42 = new iristk.flow.DialogFlow.say();
						StringCreator string43 = new StringCreator();
						string43.append("I am sorry, I didn't get that.");
						state42.setText(string43.toString());
						if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 144, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 146
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 146, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Roman\\Documents\\IrisTK-master\\app\\DialogueProject\\skiing\\src\\iristk\\app\\guess\\GuessFlow.xml"), 144, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
