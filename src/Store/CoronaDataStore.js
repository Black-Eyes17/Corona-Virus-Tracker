import { EventEmitter } from 'events'
import dispatcher from '../Dispatcher/CoronaDataDispatcher';
class CoronaDataStore extends EventEmitter
{
    constructor(props)
    {
        super(props);
        this.storeData=[];
    }

   getConfirmedCaseData(data){
        this.storeData=data
        this.emit("ConfirmedCaseDataRecieved")
   }

   getRecoveredCaseData(data){
        this.storeData=data
        this.emit("RecoveredCaseDataRecieved")
   }

   getDeathCaseData(data){
        this.storeData=data
        this.emit("DeathCaseDataRecieved")
   }

    getStoreData(){
        return this.storeData
    }
    handleEvent(action)
    {
        switch(action.type){
            case "RETRIEVE_CONFIRMED_CASE_DATA":{
                this.getConfirmedCaseData(action.data)
                break
            }
            case "RETRIEVE_RECOVERED_CASE_DATA":{
                this.getRecoveredCaseData(action.data)
                break
            }
            case "RETRIEVE_DEATH_CASE_DATA":{
                this.getDeathCaseData(action.data)
                break
            }
            default : {}
        }
    }
    
}
const store = new CoronaDataStore();
dispatcher.register(store.handleEvent.bind(store));
window.dispatcher = dispatcher;
export default store;