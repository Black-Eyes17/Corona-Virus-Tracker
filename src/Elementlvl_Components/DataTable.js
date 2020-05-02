import React from 'react';
// import * as ReactTable from "react-table";
//import BootStrapTable from 'reactjs-bootstrap-table';


export default class DataTable extends React.Component{
    render(){ 
        const isConfirmedCase=("CONFIRMED_CORONA_CASE"===this.props.content.caseDataType)
        const isRecoveredCase=("RECOVERED_CORONA_CASE"===this.props.content.caseDataType)
        const isDeathCase=("DEATH_CORONA_CASE"===this.props.content.caseDataType)
        var i = 1
        const tableData= this.props.content.data.map((coronaData)=>{
            return (
                <tbody>
                    <tr>
                        <td>{i++}</td>
                        <td>{coronaData.country}{(coronaData.state!=="")?"("+coronaData.state+")":""}</td>
                        {isConfirmedCase
                            ?<td>{coronaData.latestConfirmedCases}</td>
                            :isRecoveredCase
                                ?<td>{coronaData.latestRecoveredCases}</td>
                                :isDeathCase
                                    ?<td>{coronaData.latestDeathCases}</td>
                                    :""
                        }
                    </tr>
                </tbody>)
            })
        return(
            <center>
                <div>
                    <table border="1">
                        <tbody>
                            <tr>
                                <th>Sl No</th> 
                                <th>Country(State)</th>
                                <th>Total Number Of Cases</th>
                            </tr>
                        </tbody>
                        {tableData}
                    </table>
                </div>
            </center>
        )
        //     const columns = [{
    //         Header: "Country",
    //         accessor: "country"
    //     },
    //     {
    //         Header: "State",
    //         accessor: "state"
    //     },
    //     {
    //         Header: "Total Number of Cases",
    //         accessor: isConfirmedCase
    //                              ? "latestConfirmedCases"
    //                              :isRecoveredCase
    //                                  ? "latestRecoveredCases"
    //                                  :isDeathCase
    //                                      ? "latestDeathCases"
    //                                     :""
    //     }]
    //     return (              
    //         <div>
    //             {console.log(this.props.content.data)}  
    //             <BootStrapTable  
    //                 data={this.props.content.data}  
    //                 columns={columns}  
  
    //             />  
    //         </div>        
    //   )  
    }
}