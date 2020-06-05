<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Bootstrap core CSS -->
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/footable.bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.6.3/flatpickr.min.css" integrity="sha256-Zh4AVwxlwpUo2c5u4Z5emTmYZxbCk972ewf4tqGRsBg=" crossorigin="anonymous" />
    <style>
        body {
            background-color: #eee;
        }
        
        .dropdown-toggle::after {
            display: none;
        }
        
        table.footable>thead>tr.footable-filtering>th div.form-group {
            margin-left: 2px;
            margin-right: 2px;
            width: 100%;
        }
        
        table.footable>thead>tr.footable-filtering>th div.input-group {
            width: 100%;
        }
        
        table.footable.footable-filtering-right>thead>tr.footable-filtering>th,
        table.footable>thead>tr.footable-filtering>th {
            text-align: left;
        }
        
        .btn-modl {
            position: fixed;
            right: 2%;
            bottom: 10%;
            background-color: #4d0b8a;
            color: #fff;
        }
        
        .input-group-btn:last-child>.btn,
        .input-group-btn:last-child>.btn-group {
            display: none;
        }
        
        .c-head {
            background: linear-gradient(to bottom right, #7d0caa 0%, #4013bb 100%);
            border-bottom-left-radius: 25%;
            border-bottom-right-radius: 25%;
        }
        
        .pagination>.active>a,
        .pagination>.active>a:focus,
        .pagination>.active>a:hover,
        .pagination>.active>span,
        .pagination>.active>span:focus,
        .pagination>.active>span:hover {
            color: #fff;
            background-color: #4d0b8a;
            border-color: #4d0b8a;
        }
        
        .pagination>li>a,
        .pagination>li>span {
            color: #4d0b8a;
        }
    </style>
</head>

<body class="breadcrumb-dn mr-auto" ng-app="myApp" ng-controller="myCtrl">
    <!--Main Navigation-->
    <header class="text-center py-3 mb-2 c-head">
        <div class="container ">
            <div class="row">
                <div class="col-lg-12">
                    <img src="logo1.png" alt="" style="float: left;" width="80px" class="mr-4">
                    <h3 class="font-weight-light text-white">Temperature Reading</h3>
                    <!--  <p class="lead text-white" style="font-size: 26px;font-weight:normal;font-family:roboto">Temperature Reading</p> -->
                    <p class="lead mb-4 text-white-50"> <small> Let's save you from the COVID</small></p>
                </div>
            </div>
        </div>
    </header>
    <!--Main Navigation-->
    <!--Main layout-->
    <main>
        <div class="container mt-3 mb-3">
            <div class="row">
                <div class="col-sm-12">


                </div>
            </div>
            <div class="row bg-light">
                <table class="table" id="table" data-paging="true " data-filter="#filter " data-page-size="10 ">
                    <thead>
                        <th data-title="Employee Name ">Employee Name</th>
                        <th data-title="Shift ">Shift</th>
                        <th style="text-align: center; " data-title="Temperature Reading ">Temperature Reading</th>
                        <th data-title="Date ">Date</th>
                    </thead>
                    <tr ng-repeat="temp in tableData ">
                        <td>{{temp.appUser.name}}</td>
                        <td>{{temp.shift}}</td>
                        <td style="text-align: center; ">{{temp.reading?temp.reading:temp.noReading}}</td>
                        <td>{{temp.date | date:'dd-MMM-yyyy'}}</td>
                    </tr>
                    <tfoot class="hide-if-no-paging ">
                        <tr>
                            <td colspan="5 " class="text-center ">
                                <ul class="pagination ">
                                </ul>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </main>
    <!--Main layout-->



    <!-- Button trigger modal -->
    <button type="button " class="btn btn-modl " style="margin-bottom: 3rem; " ng-click="excel()" ng-show="tableData.length>0">
        <i class="fa fa-download " style="font-size: 28px; " aria-hidden="true "></i>
    </button>
    <button type="button" class="btn btn-modl" data-toggle="modal" data-target="#myModal">
        <i class=" fa fa-search " style="font-size: 28px; " aria-hidden="true "></i>
    </button>

    <!-- Modal -->
    <div class="modal fade " id="myModal" tabindex="-1 " role="dialog " aria-labelledby="exampleModalLabel " aria-hidden="true ">
        <div class="modal-dialog " role="document ">
            <div class="modal-content ">
                <div class="modal-header ">
                    <h5 class="modal-title " id="exampleModalLabel ">Seacrh Form</h5>
                    <button type="button " class="close " data-dismiss="modal " aria-label="Close ">
            <span aria-hidden="true ">&times;</span>
          </button>
                </div>
                <div class="modal-body ">
                    <form>
                        <div class="row">
                            <div class="form-group col-sm-6 ">
                                <label for="exampleFormControlSelect1 ">Group By</label>
                                <select class="form-control " ng-model="groupBy ">
                                <option value="">Select Temperature</option>
                                <option value="greater ">Greater than 38</option>
                                <option value="less ">Less than or Equal to 38</option>
                            </select>
                            </div>
                            <div class="form-group col-sm-6 ">
                                <label for="exampleFormControlSelect1 ">Shift</label>
                                <select class="form-control " ng-model="shift ">
                                <option value="">Select Shift</option>
                                <option value="Morning ">Morning</option>
                                <option value="Evening ">Evening</option>
                            </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6 ">
                                <label for="exampleFormControlSelect1 ">Start Date</label>
                                <input type="text " id="startDate" required="required " class="form-control " ng-model="startDate " />
                            </div>
                            <div class="form-group col-sm-6 ">
                                <label for="exampleFormControlSelect1 ">End Date</label>
                                <input type="text " id="endDate" required="required " class="form-control " ng-model="endDate " />
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer ">
                    <button type="button " class="btn btn-secondary " data-dismiss="myModal " id="closemodal ">Close</button>
                    <button type="button " class="btn btn-primary " ng-click="submit() " data-dismiss="myModal ">Submit</button>
                </div>
            </div>
        </div>
    </div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <!-- Add in any FooTable dependencies we may need -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js "></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.6.3/flatpickr.min.js " integrity="sha256-/irFIZmSo2CKXJ4rxHWfrI+yGJuI16Z005X/bENdpTY=" crossorigin=" anonymous "></script>
    <script src="resources/js/footable.min.js "></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.9/angular.min.js " integrity="sha256-b5NvmvUcyr0wpBOLnNbaWH5zKQAivhj8yMYhfXEumQA=" crossorigin=" anonymous "></script>
    <script>
        $(document).ready(function() {
            var options = {
                dateFormat: 'd-m-Y'
            }
            console.log($('#startDate'));
            $('#startDate').flatpickr(options);
            $('#endDate').flatpickr(options);
        });
        var app = angular.module('myApp', []);
        app.controller('myCtrl', function($scope, $http, $timeout) {
            $scope.groupBy = " ";
            $scope.startDate = " ";
            $scope.endDate = " ";
            $scope.shift = " "
            $scope.tableData;
            var table;

            jQuery(function($) {
               $scope.ft = FooTable.init('#table', {
            		// we only load the column definitions as the row data is loaded through the button clicks
            		 "paging ": {
                        "enabled ": true
                    },
                    "filtering ": {
                        "enabled ": true
                    },
                    "sorting ": {
                        "enabled ": true
                    }
            	});
                
            });
                $scope.submit = function() {
                var url = ${pageContext.servletContext.contextPath}'/temperatures';
                var postData = {
                    groupBy: $scope.groupBy,
                    startDate: $scope.startDate,
                    endDate: $scope.endDate,
                    shift: $scope.shift
                }
                $http({
                    url: url,
                    data: postData,
                    method: 'POST',
                    async: false,
                    config: {
                        'Content-Type': 'application/json'
                    }
                }).then(function success(response) {
                        $scope.tableData = response.data;
                        $timeout(function() {
                             $('.table').footable({
                                "paging": {
                                    "enabled": true
                                },
                                "filtering": {
                                    "enabled": true
                                },
                                "sorting": {
                                    "enabled": true
                                }
                            }).rows.load($scope.tableData)
                        }, 100);
                    },
                    function error(err) {
                        console.log(err)
                    });
            }

            $scope.excel = function() {
                var csv = FooTable.get('#table').toCSV(true);
                /*  console.log ("csv: " + csv);*/
                var hiddenElement = document.createElement('a');
                hiddenElement.href = 'data:text/csv;charset=utf-8,' + encodeURI(csv);
                hiddenElement.target = '_blank';
                hiddenElement.download = 'Temperature_Reading.csv';
                hiddenElement.click();
            }
        });
    </script>
    <!-- Placed at the end of the document so the pages load faster -->

</body>

</html>