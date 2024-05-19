<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('bands', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->string('image_path')->nullable();
            $table->timestamps();
        });

        Schema::table('songs', function (Blueprint $table) {
            $table->unsignedBigInteger('band_id')->after('name');
            $table->foreign('band_id')->references('id')->on('bands');
        });

        Schema::table('albums', function (Blueprint $table) {
            $table->unsignedBigInteger('band_id')->after('release_date');
            $table->foreign('band_id')->references('id')->on('bands');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {        
        Schema::table('songs', function (Blueprint $table) {
            $table->dropColumn('band_id');
        });
        
        Schema::table('albums', function (Blueprint $table) {
            $table->dropColumn('band_id');
        });

        Schema::dropIfExists('bands');
    }
};
