import React from 'react';
import Buttons from '../Elementlvl_Components/Button';
import CoronaDataStore from '../Store/CoronaDataStore';
import * as CoronaDataAction from '../Actions/CoronaDataAction';
import DataTable from '../Elementlvl_Components/DataTable';

export default class Content extends React.Component
{

    constructor(props)
    {
        super(props);
        this.state={
            data:[],
            isDataAvailable: false,
            caseDataType: ""
        }
    }

    componentWillMount()
    {
        CoronaDataStore.on("ConfirmedCaseDataRecieved",()=>{
            this.setState({
                data: CoronaDataStore.getStoreData(),
                isDataAvailable:true,
                caseDataType: "CONFIRMED_CORONA_CASE"
            })            
        })
        CoronaDataStore.on("RecoveredCaseDataRecieved",()=>{
            this.setState({
                data: CoronaDataStore.getStoreData(),
                isDataAvailable:true,
                caseDataType: "RECOVERED_CORONA_CASE"
            })            
        })
        CoronaDataStore.on("DeathCaseDataRecieved",()=>{
            this.setState({
                data: CoronaDataStore.getStoreData(),
                isDataAvailable:true,
                caseDataType: "DEATH_CORONA_CASE"
            })            
        })
    }

    getCoronaDeathCase(){
        CoronaDataAction.getDeathCases();
    }

    getCoronaRecoveredCase(){
        CoronaDataAction.getRecoveredCases();
    }

    getCoronaConfirmedCase(){
        CoronaDataAction.getConfirmedCases();
    }

    render(){
        return(
            <div className="content">
                <div className="coronaData">
                    {this.state.isDataAvailable
                        ? <DataTable content={this.state}/>
                        : ""
                    }
                </div>
                <div className="buttons">
                    <Buttons onClick={this.getCoronaDeathCase} value="Corona Death"/>
                    <Buttons onClick={this.getCoronaRecoveredCase} value="Corona Recovery"/>
                    <Buttons onClick={this.getCoronaConfirmedCase} value="Corona Confirmed"/>
                </div>
            </div>
        )
    }
}