<!DOCTYPE html>
<html lang="">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title Page</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
      body {
        background: linear-gradient(bottom, #52EDC7, #5AC8FB);
        background: -webkit-linear-gradient(bottom, #52EDC7, #5AC8FB); /* For Safari 5.1 to 6.0 */
        background: -o-linear-gradient(bottom, #52EDC7, #5AC8FB); /* For Opera 11.1 to 12.0 */
        background: -moz-linear-gradient(bottom, #52EDC7, #5AC8FB); /* For Firefox 3.6 to 15 */
      }
      .box {
        min-height: 100%;
        background: #ffffff;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-md-8 div col-md-offset-2 box">
          
          <ol class="breadcrumb">
            <li class="">All countries</li>
             <li class="active"> Cities </li>
            <!-- <li><a href="#">Library</a></li> -->
          </ol>
          <h2>Fusion chart showing population of cities within country</h2>
          <div id="chart-container">
            
          </div>
        </div>
      </div>
    </div>

    <!-- jQuery -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- Bootstrap JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
     <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="http://static.fusioncharts.com/code/latest/fusioncharts.js"></script>
    <script type="text/javascript" src="http://static.fusioncharts.com/code/latest/fusioncharts.charts.js"></script>
    <script type="text/javascript" src="http://static.fusioncharts.com/code/latest/themes/fusioncharts.theme.ocean.js"></script>
    <script type="text/javascript" src="/fusioncharts-jquery-plugin.js"></script>
    <script>
      var modelAttributeValue = "${countryId}";
      $.get('/country/'+modelAttributeValue,function(data){
        var graphData = data.map(function(item){
          var newItem = {
              label :item.cityName,
              value: item.population
            };
            return newItem;
        });
        $("#chart-container").insertFusionCharts({
          type: "column2d",
          width: "500",
          height: "500",
          dataFormat: "json",
          dataSource: {
              chart: {
                  caption: "Population in India",
                  palettecolors: "#008ee4,#9b59b6,#6baa01,#e44a00,#f8bd19,#d35400,#bdc3c7,#95a5a6,#34495e,#1abc9c",
                  theme: "ocean"
              },
              data: graphData
          }
        }); 
      });
    </script>
  </body>
</html>