###Difference between Stateless and Stateful Session -

####The major differences are-
| Stateless Session | Stateful Session |
| --- | ----------- |
| Any changes in the facts while executing rules is not made aware to the rule engine. | Any changes in the facts while<br> executing rules is made aware to the rule engine. |
| dispose() method is called automatically to release the session | dispose() method should be called to release the </br>session to avoid memory leaks. |
|The engine is caused to âfireâ via a call to one of the execute() methods.</br>The two variants are; </br> 1) pass a single object/fact, or 2) pass an iterable object that contains the fact(s) that will be used.|Provide a variety of methods to cause the engine to âfireâ </br>(i.e. execute the consequences of rules scheduled for activation).</br>fireAllRules() </br>fireAllRules(AgendaFilter filter) </br>fireAllRules(AgendaFilter filter, int max) </br>fireAllRules(int max)</br>fireUntilHalt()</br>fireUntilHalt(AgendaFilter filter)