var App = React.createClass({

    loadSensorReadings: function () {
        var self = this;
        $.ajax({
            url: "data/2345"
        }).then(function (data) {
          console.log(data);
          self.setState({readings: data});
        });
    },
    getInitialState: function () {
        return {readings: []};
    },
    componentDidMount: function () {
        this.loadSensorReadings();
    },
    render() {
        console.log(this.state.readings);
        return ( <div>{this.state.readings}</div> );
    }
});

ReactDOM.render(<App />, document.getElementById('root') );