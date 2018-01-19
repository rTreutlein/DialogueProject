package iristk.app.skiing;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class SkiingFlow extends iristk.flow.Flow {


	private void initVariables() {
	}

	@Override
	public Object getVariable(String name) {
		return null;
	}


	public SkiingFlow() {
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
			// Line: 8
			try {
				EXECUTION: {
					int count = getCount(195600860) + 1;
					incrCount(195600860);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Which day you're going to ski?");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 8, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 10
					Answer state2 = new Answer();
					flowThread.gotoState(state2, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 10, 26)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 8, 12));
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


	private class Answer extends Dialog {

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
					int count = getCount(1212899836) + 1;
					incrCount(1212899836);
					iristk.flow.DialogFlow.listen state3 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 15, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 15, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 18
			try {
				count = getCount(1174290147) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1174290147);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 19
							if (asInteger(event.get("sem:number")) %2 == 0) {
								iristk.flow.DialogFlow.say state4 = new iristk.flow.DialogFlow.say();
								StringCreator string5 = new StringCreator();
								string5.append("The weather is good for skiing on this day.");
								state4.setText(string5.toString());
								if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 19, 51)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 21
								More state6 = new More();
								flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 21, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 22
							} else {
								iristk.flow.DialogFlow.say state7 = new iristk.flow.DialogFlow.say();
								StringCreator string8 = new StringCreator();
								string8.append("The weather is bad for skiing on this day.");
								state7.setText(string8.toString());
								if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 19, 51)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 24
								Alternative state9 = new Alternative();
								flowThread.gotoState(state9, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 24, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 18, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Alternative extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 30
			try {
				EXECUTION: {
					int count = getCount(1407343478) + 1;
					incrCount(1407343478);
					iristk.flow.DialogFlow.say state10 = new iristk.flow.DialogFlow.say();
					StringCreator string11 = new StringCreator();
					string11.append("Do you want me to suggest an alternative day this week?");
					state10.setText(string11.toString());
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 30, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state12 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 30, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 30, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 34
			try {
				count = getCount(1940447180) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1940447180);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state13 = new iristk.flow.DialogFlow.say();
							StringCreator string14 = new StringCreator();
							string14.append("Friday.");
							state13.setText(string14.toString());
							if (!flowThread.callState(state13, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 34, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 36
							More state15 = new More();
							flowThread.gotoState(state15, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 36, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 34, 58));
			}
			// Line: 38
			try {
				count = getCount(2121744517) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2121744517);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state16 = new iristk.flow.DialogFlow.say();
							StringCreator string17 = new StringCreator();
							string17.append("Okay, goodbye");
							state16.setText(string17.toString());
							if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 38, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 40
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 38, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class More extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 44
			try {
				EXECUTION: {
					int count = getCount(476402209) + 1;
					incrCount(476402209);
					iristk.flow.DialogFlow.say state18 = new iristk.flow.DialogFlow.say();
					StringCreator string19 = new StringCreator();
					string19.append("Do you have any further questions?");
					state18.setText(string19.toString());
					if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 44, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state20 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 44, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 44, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 49
			try {
				count = getCount(1490180672) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1490180672);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state21 = new iristk.flow.DialogFlow.say();
						StringCreator string22 = new StringCreator();
						string22.append("Okay, goodbye");
						state21.setText(string22.toString());
						if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 49, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 51
						System.exit(0);
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 49, 36));
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
			// Line: 56
			try {
				count = getCount(1143839598) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1143839598);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state23 = new iristk.flow.DialogFlow.say();
						StringCreator string24 = new StringCreator();
						string24.append("I am sorry, I didn't hear anything.");
						state23.setText(string24.toString());
						if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 56, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 58
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 58, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 56, 38));
			}
			// Line: 60
			try {
				count = getCount(517938326) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(517938326);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state25 = new iristk.flow.DialogFlow.say();
						StringCreator string26 = new StringCreator();
						string26.append("I am sorry, I didn't get that.");
						state25.setText(string26.toString());
						if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 60, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 62
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 62, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\shahd\\IrisT\\templates\\simple_dialog\\src\\iristk\\app\\skiing\\SkiingFlow.xml"), 60, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
