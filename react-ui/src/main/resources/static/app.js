var App = React.createClass({
  render() {
    return ( <EmployeeTable employees={this.state.employees}/> );
  }

  render() {
    return ( <h1>Hello World</h1> );
  }

});

ReactDOM.render(<App />, document.getElementById('root') );