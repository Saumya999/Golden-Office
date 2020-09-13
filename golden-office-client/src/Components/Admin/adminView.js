import React, {Component} from 'react'
import _bindAll from 'lodash/bindAll';
import {GET_ALL_MANAGER} from './Endpoints';
import {makeUrl} from '../../config/Utility';
import axios from 'axios';
import AppBar from 'material-ui/AppBar';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import ManagerCardView from './managerCardView';

class AdminView extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
        _bindAll(this,[
            'getAllManager'
        ]);
    }

    /*** get All managers  */
    async getAllManager() {
        await axios.get(makeUrl(GET_ALL_MANAGER))
            .then(res => {
            this.setState({
                data: res
            });
      })
    }

     componentDidMount() {
        this.getAllManager();
    }

    render() {
        const managers = this.state.data;
        
        return(
            <div>
            <MuiThemeProvider>
                <div>
                    <AppBar/>
                    {managers && managers.data && <ManagerCardView {...managers} />}
                </div>
            </MuiThemeProvider>
        </div>
            
        );
    }

}

export default AdminView;