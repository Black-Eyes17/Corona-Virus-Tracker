import Dispatcher from '../Dispatcher/CoronaDataDispatcher'
import APIService from '../Service/APIService'

export function getConfirmedCases(){
    APIService.get("/confirmedCoronaCase")
        .then((coronaData) => {
            if(coronaData !=null){
                Dispatcher.dispatch({
                    type: "RETRIEVE_CONFIRMED_CASE_DATA",
                    data: coronaData
                })
            }
        })
    
}

export function getRecoveredCases(){
    APIService.get("/recoveredCoronaCase")
    .then((coronaData) => {
        if(coronaData !=null){
            Dispatcher.dispatch({
                type: "RETRIEVE_RECOVERED_CASE_DATA",
                data: coronaData
            })
        }
    })
}

export function getDeathCases(){
    APIService.get("/deathCoronaCase")
        .then((coronaData) => {
            if(coronaData !=null){
                Dispatcher.dispatch({
                    type: "RETRIEVE_DEATH_CASE_DATA",
                    data: coronaData
                })
            }
        })
}